package com.flysky.study.springweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SysSpringContextUtil {

    public static ApplicationContext getContext() {
        return context;
    }

    @Autowired
    public void setContext(ApplicationContext context) {
        SysSpringContextUtil.context = context;
    }

    public static  <T> T getBean(String beanName) {
        return (T) context.getBean(beanName);
    }

    public static  <T> T getBean(Class<T> klass) {
        return (T) context.getBean(klass);
    }

    @Autowired
    private static ApplicationContext context;


}
