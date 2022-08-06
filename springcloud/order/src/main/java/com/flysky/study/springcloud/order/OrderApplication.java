package com.flysky.study.springcloud.order;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 演示 http方式调用服务的几种方式<br>
 */
@SpringBootApplication
@EnableFeignClients
@RestController
public class OrderApplication {

    private String user_server = "http://localhost:1234/user";

    /**
     * 最原始的：通过url直接调用服务<br>
     *     需要记住每个具体的地址
     */
    @RequestMapping("/origin")
    public String origin() {
        String result = restTemplate.getForObject(user_server, String.class);
        return "client invoke server by origin:" + user_server + "-result=" + result;
    }

    /**
     * 通过eureka获取服务提供者具体地址，然后直接端到端调用<br>
     *     无需记录地址
     */
    @RequestMapping("/eureka_client")
    public String restTemplateForEurekaClient() {
        String userUrl = serviceUrl() + "user";
        String result = restTemplate.getForObject(userUrl, String.class);
        return "client invoke server by eureka_client:" + serviceUrl() + "-result=" + result;
    }

    /**
     * 通过OpenFeign即声明式的Rest客户端方式调用<br>
     *     无须记录地址，无须restTemplate，但需要显示声明服务提供者接口
     */
    @RequestMapping("/feign")
    public String feignClient() {
        return "client invoke server by feign:" + userClient.hello();
    }

    /**
     * 直接借助eureka+RestTemplate+LoadBalance+注册的服务名进行调用<br>
     * 特点：灵活+通用+推荐；只需记录eureka地址+服务名称（当然访问具体资源必须先知晓）即可
     */
    @RequestMapping("/eureka_server")
    public String restTemplateForServerName() {
        String userUrl = "http://user/user";//===http://user替换成Ip和端口,/user会追加到后面的路径中
        String result = restTemplateLoadBalanced.getForObject(userUrl, String.class);
        return "client invoke server by service_name_of_eureka:" + result;
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(OrderApplication.class).web(WebApplicationType.SERVLET).run(args);
    }

    @FeignClient("user")
    interface UserClient {
        @RequestMapping(value = "/user", method = RequestMethod.GET)
        String hello();
    }

    @Autowired
    private UserClient userClient;
    @Autowired
    private EurekaClient discoveryClient;
    // Spring框架对RESTful方式的http请求做了封装，来简化操作
    @Autowired
    private RestTemplate restTemplateLoadBalanced;
    private RestTemplate restTemplate= new RestTemplate();


    public String serviceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("user", false);
        return instance.getHomePageUrl();
    }


}
