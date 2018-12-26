package com.flysky.study;


import com.flysky.study.service.ActionService;
import com.flysky.study.service.MessageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MockitoApplication.class)
public class MockitoApplicationTest {

    @MockBean
    private ActionService actionService;

    @Autowired
    private MessageService messageService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(actionService.doSay(anyString())).thenReturn("hello world");
    }

    @Test
    public void test() {
        System.out.println(messageService.say("name2"));
        verify(actionService, atLeastOnce()).doSay("name2");
    }

}
