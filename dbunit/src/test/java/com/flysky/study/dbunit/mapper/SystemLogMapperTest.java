package com.flysky.study.dbunit.mapper;

import com.alibaba.fastjson.JSON;
import com.flysky.study.dbunit.model.SystemLog;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        MockitoTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
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

}