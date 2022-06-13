package com.flysky.study.dbrider.error;

import com.flysky.study.config.TransactionalDevTestConfigMysql;
import com.flysky.study.mybatis.dao.EoaTaskDao;
import com.flysky.study.mybatis.model.EoaTask;
import com.flysky.study.mybatis.serivce.EoaTaskService;
import com.flysky.study.mybatis.serivce.impl.EoaTaskServiceImpl;
import com.github.database.rider.core.api.connection.ConnectionHolder;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.dataset.DataSetExecutorImpl;
import com.github.database.rider.spring.api.DBRider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


@TransactionalDevTestConfigMysql
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {EoaTaskServiceImpl.class, EoaTaskDao.class}
)
//多数据源只能在测试类中使用此注解，否则获取到的连接会使用其它测试创建的连接，因为默认会缓存连接
@DBRider(dataSourceBeanName = "ds-mysql")

@DataSet(value = "eoa_task.xml",executorId = "abc")
public class EoaTaskServiceMySqlTest {

    @Test
    public void should_return_two_rows() {
        System.out.println("name2DataSources = " + name2DataSources);
        System.out.println("eoaTaskService = " + eoaTaskService);
//        System.out.println("ds = " + ds+",url="+ds.getUrl());
        List<EoaTask> eoaTasks = eoaTaskService.list();
        assertThat(eoaTasks.size()).isEqualTo(2);
    }

    @FunctionalInterface
    interface  F{
        A f();
    }
    class A{
        void print(F f) {

        }

        F f() {
            return null;
        }

        public  void main(String[] args) throws SQLException {
            A a = new A();

            DataSource dataSource = null;
            ConnectionHolder getConnection = dataSource::getConnection;
//            getConnection=dataSource.getConnection();
            DataSetExecutorImpl.instance("instanceId", getConnection);
//            DataSetExecutorImpl.instance("instanceId", dataSource.getConnection());
        }
    }

    @Autowired
    private Map<String, DataSource> name2DataSources;

    @Autowired
    private EoaTaskService eoaTaskService;

//    @Autowired
//    private DriverManagerDataSource ds;
}
