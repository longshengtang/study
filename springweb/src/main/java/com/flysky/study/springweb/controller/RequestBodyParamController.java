package com.flysky.study.springweb.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RequestBodyParamController {
    @RequestMapping("dateBody")
    public RequestBodyWithDateParamVo dateBody(@RequestBody RequestBodyWithDateParamVo body) {
        logger.info("参数：{}", JSON.toJSONStringWithDateFormat(body,"yyyy-MM-dd HH:mm:ss.SSSZ"));
        return body;
    }

    private static final Logger logger = LoggerFactory.getLogger(RequestBodyParamController.class);

}
