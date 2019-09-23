package com.flysky.study.validation.jdk;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Validator;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ValidationTest.class)
@ComponentScan("com.flysky.study.validation.jdk")
@EnableWebMvc
public class ValidationTest {

    @Test
    public void test() {
        Assertions.assertThat(validator).isNotNull();
    }

    @Autowired
    private Validator validator;
}
