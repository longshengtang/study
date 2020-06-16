package com.flysky.study.dbunit.mapper;

import com.alibaba.fastjson.JSON;
import com.flysky.study.dbunit.config.TransactionalDevTestConfig;
import com.flysky.study.mybatis.mapper.SystemLogMapper;
import com.flysky.study.mybatis.model.SystemLog;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DBUnit(allowEmptyFields = true,caseSensitiveTableNames = true)
@DBRider
//@Transactional
@TransactionalDevTestConfig
public class SystemLogMapperRiderTest  {

//    @Autowired
    @Autowired
    private SystemLogMapper mapper;

    @DataSet("systemLog.yml")
    @Test
    public void selectById() {
        SystemLog systemLog = mapper.selectById(3L);
        Assertions.assertThat(systemLog).isNotNull();
        System.out.println(JSON.toJSONString(systemLog));
    }


//    @ExpectedDatabase(table = "system_log", value = "system_log_exp.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
//    @Test
//    public void testInsert() {
//        int i = 4;
//        while (i++ < 100) {
//            SystemLog systemLog = new SystemLog();
//            systemLog.setMenuId(i).setOperationId(i).setContent("testInsert" + i);
//            mapper.insert(systemLog);
//        }
//    }

}