package com.flysky.study.validation.spring;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.util.NestedServletException;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ComponentScan("com.flysky.study.validation.spring")
@SpringBootTest(classes = MethodValidationControllerTest.class)
@EnableWebMvc//使用此注解或者继承WebMvcConfigurationSupport都可以解决No converter的总是
public class MethodValidationControllerTest /*extends WebMvcConfigurationSupport*/ {

    @Autowired
    private WebApplicationContext wac;

    @Rule
    public ExpectedException e = ExpectedException.none();

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void test() throws Exception {
        e.expect(NestedServletException.class);
        e.expectMessage("test.b: 最小不能小于0");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/a")
                .param("a", "123")
                .param("b", "-1")
        )
                .andDo(print())
                .andExpect(status().isOk())

        ;
    }


    private MockMvc mockMvc;
}