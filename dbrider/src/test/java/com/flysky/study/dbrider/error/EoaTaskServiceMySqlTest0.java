package com.flysky.study.dbrider.error;

import com.flysky.study.config.TransactionalDevTestConfigH2;
import com.flysky.study.mybatis.dao.EoaTaskDao;
import com.flysky.study.mybatis.model.EoaTask;
import com.flysky.study.mybatis.serivce.EoaTaskService;
import com.flysky.study.mybatis.serivce.impl.EoaTaskServiceImpl;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.Date;
import java.util.Map;


@RunWith(SpringRunner.class)
//@TransactionalDevTestConfigMysql
//@DBRider(dataSourceBeanName = "ds-mysql")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {EoaTaskServiceImpl.class, EoaTaskDao.class}
)
@TransactionalDevTestConfigH2
@DBRider(dataSourceBeanName = "ds-h2")
@DataSet(value = "eoa_task.xml",cleanBefore = false)

//@DataSet("empty_eoa_task.xml")
public class EoaTaskServiceMySqlTest0 {

    @Test
//    @DataSet(value = "empty_eoa_task.xml"/*,strategy = SeedStrategy.INSERT*/)
//    @DataSet("expected_eoa_task.xml")
    @ExpectedDataSet(value = "expected_eoa_task.xml",ignoreCols = {"created_date","id"})
    public void should_save_two_rows() {
        System.out.println("name2DataSources = " + name2DataSources);
        System.out.println("eoaTaskService = " + eoaTaskService);
//        System.out.println("ds = " + ds+",url="+ds.getUrl());
        eoaTaskService.saveTwoRows();
    }

    @Test
    public void should_not_null() {
        EoaTask eoaTask = new EoaTask().setCreatedBy("flysky")
                .setCreatedDate(new Date())
                .setStatus(1)
                .setTaskDetailList("任务详情")
                ;
        expectedException.expect(RuntimeException.class);
        eoaTaskService.save(eoaTask);

    }

    @Rule
    public ExpectedException expectedException= ExpectedException.none();

    @Autowired
    private Map<String, DataSource> name2DataSources;

    @Autowired
    private EoaTaskService eoaTaskService;

//    @Autowired
//    private DriverManagerDataSource ds;
}
