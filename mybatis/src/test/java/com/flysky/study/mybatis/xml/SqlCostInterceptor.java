package com.flysky.study.mybatis.xml;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Intercepts({
        //如果同时监听两个接口，那么会会多一次代理，性能不是很好。推荐只输出sql
        //只代理StatementHandler无法获取执行的方法名称。但性能较高
        @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
        @Signature(type = StatementHandler.class, method = "update", args = {Statement.class}),
        @Signature(type = StatementHandler.class, method = "batch", args = {Statement.class}),

        //用于获取执行的方法名称-但多了一次代理，性能反而不怎么好。//只代理Executor接口需要重复计算BoundSql.//好处是可以直接获取语句名称+configuration
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
}

)
public class SqlCostInterceptor implements Interceptor {
    private static final Logger logger = LoggerFactory.getLogger(SqlCostInterceptor.class);
    private static volatile Configuration configuration;
    private static volatile boolean initedConfiguration = false;

    private ThreadLocal<String> currentStatementId = new ThreadLocal<>();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long beginTime = System.currentTimeMillis();
        try {
            if (invocation.getTarget() instanceof Executor) {
                currentStatementId.set(((MappedStatement) invocation.getArgs()[0]).getId());
            }
            return invocation.proceed();
        } finally {
            //根据@Signature.type
            //target最终可能是 StatementHandler、Executor、$ProxyN 其中之一
            String statementId = currentStatementId.get();
            currentStatementId.remove();//只有当target为Executor，才需要移除
            if (invocation.getTarget() instanceof StatementHandler) {
                printFinalSql((StatementHandler) invocation.getTarget(), beginTime, statementId);
            }
        }
    }

    private void printFinalSql(StatementHandler statementHandler, long beginTime, String statementId) {
        Configuration configuration = getConfiguration(statementHandler);
        if (configuration == null) {
            return;
        }
        String fullSql = getFullSql(configuration, statementHandler.getBoundSql());
        logger.info("printFinalSql耗时=" + (System.currentTimeMillis() - beginTime) + "---\n" +
                "" + statementId +
                ":\n" + fullSql);
    }

    /**
     * 反射方式获取Configuration
     *
     * @param handler
     * @return
     */
    private Configuration getConfiguration(StatementHandler handler) {
        if (initedConfiguration) {
            return configuration;
        }
        if (configuration == null) {
            synchronized (SqlCostInterceptor.class) {
                if (configuration == null) {
                    initedConfiguration = true;//只会被执行一次
                    try {
                        Field delegate = handler.getClass().getDeclaredField("delegate");
                        delegate.setAccessible(true);
                        Object targetHandler = delegate.get(handler);

                        Field configField = BaseStatementHandler.class.getDeclaredField("configuration");
                        configField.setAccessible(true);
                        configuration = (Configuration) configField.get(targetHandler);
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return configuration;
    }


    public String getFullSql(Configuration configuration, BoundSql boundSql) {

        Object parameterObject = boundSql.getParameterObject();

        TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();

        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();

        if (parameterMappings == null || parameterMappings.isEmpty()) {
            return boundSql.getSql();
        }
        List<Object> paramList = new ArrayList<>();

        for (int i = 0; i < parameterMappings.size(); i++) {
            ParameterMapping parameterMapping = parameterMappings.get(i);
            if (parameterMapping.getMode() == ParameterMode.OUT) {
                continue;
            }
            Object value = null;
            String propertyName = parameterMapping.getProperty();
            if (boundSql.hasAdditionalParameter(propertyName)) { // issue #448 ask first for additional params
                value = boundSql.getAdditionalParameter(propertyName);
            } else if (parameterObject == null) {
                value = null;
            } else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                value = parameterObject;
            } else {
                MetaObject metaObject = configuration.newMetaObject(parameterObject);
                value = metaObject.getValue(propertyName);
            }
            paramList.add(value);
        }
        String sql = boundSql.getSql();
        for (Object o : paramList) {
            sql = sql.replaceFirst("\\?", formatParamValue(o));
        }

        return prettySql(sql);
    }

    private String prettySql(String sql) {
        return sql.replaceAll("[\\s\n]+", " ");
    }

    public String formatParamValue(Object paramValue) {
        if (paramValue == null) {
            return "null";
        }
        if (paramValue instanceof String) {
            paramValue = "'" + paramValue + "'";
        }
        if (paramValue instanceof Date) {
            paramValue = "'" + paramValue + "'";
        }
        return paramValue.toString();
    }
}
