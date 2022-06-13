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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@TransactionalDevTestConfigMysql

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {EoaTaskServiceImpl.class, EoaTaskDao.class}
)
@DBRider(dataSourceBeanName = "ds-mysql")
@Transactional
public class BaseTest {

    @DataSet(value = "eoa_task.xml")
    @Test
    public void should_clear_table() {
        List<EoaTask> list = eoaTaskService.list();
        assertThat(list).isNotEmpty()
        .hasSize(2)
        .extracting("taskName")
        .contains("任务名称")
        ;
    }

    @Autowired
    private EoaTaskService eoaTaskService;
}