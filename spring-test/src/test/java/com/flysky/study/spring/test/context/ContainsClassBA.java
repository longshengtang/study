package com.flysky.study.spring.test.context;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE
        ,classes = {ClassB.class,ClassA.class})
public class ContainsClassBA extends BaseTest{
}