package com.flysky.study.springcloud.order;

import feign.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {
    @Bean
    @LoadBalanced//必须有，不然通过服务名称从eureka获取服务会报错。
    // 有此注解之后，非服务名称都不能使用了！！！
    // 需要使用域名的地址，直接new一个吧
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Logger.Level feignLoggerLevel(){
        return  Logger.Level.FULL;
    }


    @Bean
    public GsonHttpMessageConverter gsonHttpMessageConverter() {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();

        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        mediaTypes.add(MediaType.TEXT_PLAIN);
        // ...可以按照项目实际需要，新增多个
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converter.setSupportedMediaTypes(mediaTypes);
        // 此处可以替换默认的jackson类，替换成gson类处理
        // converter.setGson(GsonHelper.getGson());
        return converter;
    }
}
