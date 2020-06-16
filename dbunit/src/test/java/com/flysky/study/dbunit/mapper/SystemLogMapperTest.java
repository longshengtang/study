package com.flysky.study.dbunit.mapper;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.alibaba.fastjson.JSON;
import com.flysky.study.mybatis.mapper.SystemLogMapper;
import com.flysky.study.mybatis.model.SystemLog;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.assertj.core.api.Assertions;
import org.dbunit.database.QueryDataSet;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

@Ignore
@RunWith(SpringRunner.class)
@MapperScan(basePackages = {"com.flysky.study.mybatis.mapper"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ContextConfiguration(classes = {
        DruidDataSourceAutoConfigure.class
        , MybatisAutoConfiguration.class
        , DataSourceTransactionManagerAutoConfiguration.class
        , QueryDataSet.class
})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        MockitoTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@Transactional
//https://www.cnblogs.com/jishujinjie/p/7294894.html
//DBUnit支持将准备的数据放置在一个xml文件中，在执行测试用例之前自动同步到数据库中，执行完成后数据也可以自动销毁。
@DatabaseSetup("system_log.xml")
public class SystemLogMapperTest {

    @Autowired
    private SystemLogMapper mapper;

    @Test
    public void selectById() {
        SystemLog systemLog = mapper.selectById(3L);
        Assertions.assertThat(systemLog).isNotNull();
        System.out.println(JSON.toJSONString(systemLog));
    }


    @ExpectedDatabase(table = "system_log", value = "system_log_exp.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
//    @ExpectedDatabase(table = "system_log", value = "system_log_exp.xml", columnFilters = {DefaultColumnFilter.class})
//    @ExpectedDatabase(value = "system_log_exp.xml",assertionMode = DatabaseAssertionMode.NON_STRICT)
    @Test
    public void testInsert() {
        SystemLog systemLog = new SystemLog();
        systemLog.setMenuId(3).setOperationId(1).setContent("testInsert");
        Assertions.assertThat(systemLog.getId()).isNull();
        mapper.insert(systemLog);
        Assertions.assertThat(systemLog.getId()).isNotNull();
        System.out.println("-------------------------------");
    }

}