package com.flysky.study.mybatis.serivce.impl;

import com.flysky.study.mybatis.mapper.SystemLogMapper;
import com.flysky.study.mybatis.model.SysUser;
import com.flysky.study.mybatis.model.SystemLog;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SysUserServiceImplTest {

    @Mock
    private SystemLogMapper mockLogMapper;

    @InjectMocks
    private SysUserServiceImpl sysUserServiceImplUnderTest;

    @org.junit.Test
    public void testInnerThrowException1() {
        // Setup
        when(mockLogMapper.insert(any(SystemLog.class))).thenReturn(0);

        // Run the test
        sysUserServiceImplUnderTest.innerThrowException();

        // Verify the results
        verify(mockLogMapper).insert(any(SystemLog.class));
    }

    @org.junit.Test
    public void testSaveAndLog1() {
        // Setup
        final SysUser user = new SysUser();
        user.setId(0L);
        user.setName("name");
        user.setUserName("userName");
        user.setPassword("password");
        user.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setTestId(0);

        when(mockLogMapper.insert(any(SystemLog.class))).thenReturn(0);

        // Run the test
        final int result = sysUserServiceImplUnderTest.saveAndLog(user);

        // Verify the results
        assertEquals(0, result);
        verify(mockLogMapper).insert(any(SystemLog.class));
    }

    @Test
    void testSaveAndLog() {
        // Setup
        final SysUser user = new SysUser();
        user.setId(0L);
        user.setName("name");
        user.setUserName("userName");
        user.setPassword("password");
        user.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setUpdateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setTestId(0);

        when(mockLogMapper.insert(any(SystemLog.class))).thenReturn(0);

        // Run the test
        final int result = sysUserServiceImplUnderTest.saveAndLog(user);

        // Verify the results
        assertThat(result).isEqualTo(0);
        verify(mockLogMapper).insert(any(SystemLog.class));
    }

    @Test
    void testInnerThrowException() {
        // Setup
        when(mockLogMapper.insert(any(SystemLog.class))).thenReturn(0);

        // Run the test
        sysUserServiceImplUnderTest.innerThrowException();

        // Verify the results
        verify(mockLogMapper).insert(any(SystemLog.class));
    }
}
