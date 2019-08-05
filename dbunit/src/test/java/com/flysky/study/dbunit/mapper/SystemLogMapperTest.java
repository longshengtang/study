package com.flysky.study.dbunit.mapper;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.alibaba.fastjson.JSON;
import com.flysky.study.mybatis.mapper.SystemLogMapper;
import com.flysky.study.mybatis.model.SystemLog;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.assertj.core.api.Assertions;
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

@RunWith(SpringRunner.class)
@MapperScan(basePackages = {"com.flysky.study.mybatis.mapper"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ContextConfiguration(classes = {
        DruidDataSourceAutoConfigure.class
        , MybatisAutoConfiguration.class
        , DataSourceTransactionManagerAutoConfiguration.class
})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        MockitoTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@Transactional
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
    @Test
    public void testInsert() {
        SystemLog systemLog = new SystemLog();
        systemLog.setMenuId(1).setOperationId(1).setContent("1");
        Assertions.assertThat(systemLog.getId()).isNull();
        mapper.insert(systemLog);
        Assertions.assertThat(systemLog.getId()).isNotNull();
    }
}