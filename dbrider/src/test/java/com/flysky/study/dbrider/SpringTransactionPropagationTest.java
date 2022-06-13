package com.flysky.study.dbrider;

import com.flysky.study.config.TransactionalDevTestConfigMysql;
import com.flysky.study.mybatis.dao.EoaTaskDao;
import com.flysky.study.mybatis.serivce.EoaTaskService;
import com.flysky.study.mybatis.serivce.impl.EoaTaskServiceImpl;
import com.flysky.study.mybatis.serivce.impl.SysUserServiceImpl;
import com.github.database.rider.spring.api.DBRider;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@TransactionalDevTestConfigMysql
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {EoaTaskServiceImpl.class
        , EoaTaskDao.class
        , SysUserServiceImpl.class
}
)
@DBRider(dataSourceBeanName = "ds-mysql")
@EnableTransactionManagement//这个才能使得service中的Transactional生效
public class SpringTransactionPropagationTest {

//    @Rollback(false)
    @Commit//改变默认回滚方式为提交
    @Test
    public void should_throw_UnexpectedRollbackException() {
        expRule.expect(UnexpectedRollbackException.class);
        expRule.expectMessage("Transaction rolled back because it has been marked as rollback-only");
        eoaTaskService.propagationRequiredInnerExceptionCaughtByOuterMethod();
    }

    @Rule
    public ExpectedException expRule = ExpectedException.none();

    @Autowired
    private EoaTaskService eoaTaskService;
}
