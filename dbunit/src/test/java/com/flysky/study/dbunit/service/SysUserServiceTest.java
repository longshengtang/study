package com.flysky.study.dbunit.service;

import com.flysky.study.dbunit.config.TransactionalDevTestConfig;
import com.flysky.study.mybatis.model.SysUser;
import com.flysky.study.mybatis.serivce.SysUserService;
import com.flysky.study.mybatis.serivce.impl.SysUserServiceImpl;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.model.MultipleFailureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@TransactionalDevTestConfig
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SysUserServiceImpl.class})
@EnableTransactionManagement
public class SysUserServiceTest {
    @BeforeTransaction
    public void beforeTransaction() {
        System.out.println("-----");
    }
    @Rollback(false)
    @Test
    public void whenSaveSuccessfullyAndLogFailedThenThrowRuntimeExceptionAndRollback() {
        SysUser user=new SysUser();
        user.setName("您好");
        user.setUserName("hello world!");
        exp.expect(MultipleFailureException.class);
        exp.expectMessage("模拟事务异常，希望能够回滚已经成功保存的用户");
        exp.expectMessage("Transaction rolled back because it has been marked as rollback-only");
        userService.saveAndLog(user);
    }
    @Rule
    public ExpectedException exp=ExpectedException.none();

    @Autowired
    private SysUserService userService;



}
