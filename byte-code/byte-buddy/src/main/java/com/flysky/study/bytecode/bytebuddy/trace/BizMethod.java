package com.flysky.study.bytecode.bytebuddy.trace;

import java.util.Random;

public class BizMethod {

    public String queryUserInfo(String uid, String token) throws InterruptedException {
        Thread.sleep(new Random().nextInt(500));
        return "德莱联盟，王牌工程师。小傅哥(公众号：bugstack虫洞栈)，申请出栈！";
    }

}
