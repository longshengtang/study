//package com.flysky.study.springweb.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.flysky.study.comm.util.DateUtil;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//public class RequestBodyParamControllerTest {
//    private MockMvc mockMvc;
//    @Autowired
//    private WebApplicationContext wac;
//
//    @Before
//    public void setup() {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//    }
//
//    @Test
//    public void dateBody() throws Exception {
//        RequestBodyWithDateParamVo vo = new RequestBodyWithDateParamVo();
//        String validityDateTime = "2019-11-11 11:11:11";
//        vo.setValidityDate(DateUtil.parseDateTime(validityDateTime));
//        String birthDay = "2019-10-19";
//        vo.setBirthDay(DateUtil.parseDate(birthDay));
//        String u = JSON.toJSONStringWithDateFormat(vo, "yyyy-MM-dd HH:mm:ss");
//        System.out.println(u);
//        mockMvc.perform(
//                post("/test/dateBody")
//                        .contentType(MediaType.APPLICATION_JSON_UTF8)
//                        .content(u)
//        )
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.validityDate").value(validityDateTime))
//                .andExpect(jsonPath("$.birthDay").value(birthDay+" 00:00:00"))
//        ;
//    }
//
//
//}