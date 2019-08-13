package com.flysky.study.springweb.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import com.alibaba.fastjson.JSON;
import com.flysky.study.mybatis.model.SysUser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class TestControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
    }


    @Test
    public void getSysUserById() throws Exception {
        mockMvc.perform(
                post("/test/getSysUserById")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(JSON.toJSONString(new SysUser().setId(3L).setName("name")))
        )
                .andDo(print())
                .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(3))
        ;
    }


}