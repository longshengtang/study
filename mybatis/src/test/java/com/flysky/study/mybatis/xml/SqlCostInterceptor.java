package com.flysky.study.mybatis.xml;

import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Intercepts({@Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
        @Signature(type = StatementHandler.class, method = "update", args = {Statement.class}),
        @Signature(type = StatementHandler.class, method = "batch", args = {Statement.class})})
public class SqlCostInterceptor implements Interceptor {
    private static volatile Configuration configuration;
    private static volatile boolean initedConfiguration = false;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        long beginTime = System.currentTimeMillis();
        try {
            return invocation.proceed();
        } finally {
            printFinalSql((StatementHandler) invocation.getTarget(), beginTime);
        }
    }

    private void printFinalSql(StatementHandler statementHandler, long beginTime) {
        Configuration configuration = getConfiguration(statementHandler);
        if (configuration == null) {
            return;
        }
        String fullSql = getFullSql(configuration, statementHandler.getBoundSql());
        System.out.println("printFinalSql: beginTime = " + beginTime + ",endTime=" + System.currentTimeMillis() + "---\n" + fullSql);
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
                    initedConfiguration = true;
                    try {
                        System.out.println("反射获取Configuration");
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

    /**
     * 获取完整的sql（推荐方案）
     */
    public String getFullSql(Configuration configuration, BoundSql boundSql) {

        Object parameterObject = boundSql.getParameterObject();

        TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();

        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();

        if (parameterMappings == null || parameterMappings.isEmpty()) {
            return null;
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
                /*TypeHandler typeHandler = parameterMapping.getTypeHandler();
                JdbcType jdbcType = parameterMapping.getJdbcType();
                if (value == null && jdbcType == null) {
                    jdbcType = configuration.getJdbcTypeForNull();
                }*/
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
