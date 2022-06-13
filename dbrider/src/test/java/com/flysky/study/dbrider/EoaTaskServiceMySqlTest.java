package com.flysky.study.dbrider;

import com.flysky.study.config.TransactionalDevTestConfigMysql;
import com.flysky.study.mybatis.dao.EoaTaskDao;
import com.flysky.study.mybatis.model.EoaTask;
import com.flysky.study.mybatis.serivce.EoaTaskService;
import com.flysky.study.mybatis.serivce.impl.EoaTaskServiceImpl;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;



@TransactionalDevTestConfigMysql
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {EoaTaskServiceImpl.class
        , EoaTaskDao.class
}
)
@DBRider(dataSourceBeanName = "ds-mysql")
public class EoaTaskServiceMySqlTest {
    @DataSet(value = "eoa_task.xml")
    @Test
    public void should_return_two_rows() {
        System.out.println("name2DataSources = " + name2DataSources);
        System.out.println("eoaTaskService = " + eoaTaskService);
        System.out.println("ds = " + ds+",url="+ds.getUrl());
        List<EoaTask> eoaTasks = eoaTaskService.list();
        assertThat(eoaTasks.size()).isEqualTo(2);
    }

    @Autowired
    private Map<String, DataSource> name2DataSources;

    @Autowired
    private EoaTaskService eoaTaskService;

    @Autowired
    private DriverManagerDataSource ds;
}
