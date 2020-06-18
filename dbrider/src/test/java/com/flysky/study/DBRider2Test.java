package com.flysky.study;

import com.flysky.study.config.TransactionalDevTestConfig;
import com.flysky.study.mybatis.mapper.SystemLogMapper;
import com.flysky.study.mybatis.model.SystemLog;
import com.flysky.study.mybatis.serivce.impl.SysUserServiceImpl;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TransactionalDevTestConfig
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {SysUserServiceImpl.class}
)
@DBRider
@DBUnit(allowEmptyFields = true, caseSensitiveTableNames = true/*,caseInsensitiveStrategy = Orthography.LOWERCASE*/)
@DataSet(value = "system_log2.xml")
//@DataSet(value = "systemLog.yml")
//@ActiveProfiles("mysql")
@ActiveProfiles("h2")
//@ActiveProfiles("hsql")
public class DBRider2Test {
    @Autowired
    private SystemLogMapper logMapper;

    @Test
    public void testMapperSelectList() {
        List<SystemLog> systemLogs = logMapper.selectList(null);
        assertThat(systemLogs.size()).isEqualTo(13);
    }

}

