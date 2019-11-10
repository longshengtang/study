package com.flysky.study.dbunit.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@TransactionalDevTestConfig
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SysUserServiceTest2.class})
public class SysUserServiceTest2 {
    @Test
    public void whenSaveSuccessfullyAndLogFailedThenThrowRuntimeExceptionAndRollback() {
        System.out.println("-----");
    }

}
