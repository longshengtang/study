package com.flysky.study.spring.cloud.nacos.dubbo.consumer;

import com.alibaba.fastjson.JSONObject;
import com.flysky.study.spring.cloud.alibaba.naco.dubbo.GoodsDetailDTO;
import com.flysky.study.spring.cloud.alibaba.naco.dubbo.GoodsService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class DubboConsumerApplication {
    // 要调用的远程服务
    @DubboReference(check = false)
    private GoodsService goodsService;

    public String booking(Long id, int num) {
        GoodsDetailDTO goods = this.goodsService.findGoodsById(id);
        System.out.println(JSONObject.toJSONString(goods));

        return goods.getGoodsName();
    }

    @RequestMapping("/")
    public String home() {
        return booking(1L,2);
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(DubboConsumerApplication.class).web(WebApplicationType.SERVLET).run(args);
    }

}
