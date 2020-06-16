package com.flysky.study;

import com.flysky.study.config.TransactionalDevTestConfig;
import com.flysky.study.mybatis.mapper.SystemLogMapper;
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

@TransactionalDevTestConfig
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {SysUserServiceImpl.class}
)
@DBRider
@DBUnit(allowEmptyFields = true, caseSensitiveTableNames = true/*,caseInsensitiveStrategy = Orthography.LOWERCASE*/)
@DataSet(value = "system_log.xml")
//@DataSet(value = "systemLog.yml")
//@ActiveProfiles("mysql")
@ActiveProfiles("h2")
//@ActiveProfiles("hsql")
public class DBRiderTest {
    @Autowired
    private SystemLogMapper logMapper;

    @Test
    public void testMapperSelectList() {
        logMapper.selectList(null);
    }

}

