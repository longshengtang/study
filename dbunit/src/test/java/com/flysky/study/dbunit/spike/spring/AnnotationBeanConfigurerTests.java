/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flysky.study.dbunit.spike.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

import java.util.stream.Stream;

/**
 * Tests that @EnableSpringConfigured properly registers an
 * {@link org.springframework.beans.factory.aspectj.AnnotationBeanConfigurerAspect},
 * just as does {@code <context:spring-configured>}.
 *
 * @author Chris Beams
 * @since 3.1
 */
public class AnnotationBeanConfigurerTests {

    @Test
    public void injection() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class)) {
            ShouldBeConfiguredBySpring myObject = new ShouldBeConfiguredBySpring();
            Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
//			assertEquals("Rod", myObject.getName());
            assert myObject.getMySpringBean() != null:"自动注入对象属性不能为空！";
            System.out.println((myObject.getMySpringBean()) + "===============");
        }
    }


    @Configuration
//	@ImportResource("org/springframework/beans/factory/aspectj/beanConfigurerTests-beans.xml")
    @EnableSpringConfigured
    static class Config {
        @Bean
        MySpringBean getMySpringBean() {
            return new MySpringBean();
        }
    }

}
