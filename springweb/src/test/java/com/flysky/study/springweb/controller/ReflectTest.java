package com.flysky.study.springweb.controller;

import com.flysky.study.springweb.restfull.SignUtil;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ReflectTest {
    String p = "out_trade_no=5d56ac9b2e876&ts=1565961371&offer_id=1450016120&product_id=txspvip_1month&contract_no=1_2_3&provide_uin=773632134&user_id=hanjunspirit&user_name=hanjun&user_id_type=taobao&user_ip=10.175.129.45&version=1.0&drm_info=&sale_price=2000&sub_channel_id=jd&remark=key1%3Dval1%26key2%3Dval2&provide_no_type=uin&action=direct_proivde&sig=kaHdmnbjRShSszbVgoW8ETWR%2BD%2BwHknM%2Bsfso0zDsrH%2FgN%2FeMI6EyZmHw5WrivK668fkdV%2F4xPx0VfrSZUUSIX%2ByQ28l%2FJyhOTvlrBvDL01kbaYJaT%2Fp6Dc%2BV6lj5rI2GlM9kqMPFZody5u6lu9Q0CJJHXYmjuHBG6uLbo2TWzb1RtE7mNnWgQQoDJbMxjSxqg0Ea5i5Rt134kWkGyezNM3Tmja3rbidAtWEmosza8y9Iy%2FOVhViPuWaS7VQ5nLePTJuf%2FINFraUWJ6JUv8fRicClFlEggm7G6Q3BMYpoe9JgE5EuT5s%2BQojKR1ZJ2hR%2FjKl3IY6Us3IdmbNNgMSRQ%3D%3D";

    @Test
    public void test() {
        Map<String, String> req = new HashMap<>();
        req.put("out_trade_no", "out_trade_no");
        req.put("ts", "1565961371");
//        req.put("","");
        Object result = restTemplate.postForObject("https://sandbox.pay.qq.com/cgi-bin/rewardpf/reward_pf_exchange.fcg"
                ,
                req
                ,
                Object.class
        );

        System.out.println("result = " + result);
    }

    @Test
    public void test_split_p() {

        String result = sort_params();

        System.out.println(result);
    }

    private String sort_params() {
        Map<String, String> tree = sort_map_params();

        String result = getSignContent(tree);
        return result;
    }

    private String getSignContent(Map<String, String> tree) {
        return tree.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining("&"));
    }

    private Map<String, String> sort_map_params() {
        Map<String, String> tree = new TreeMap<>();
        for (String s : p.split("&")) {
            String[] split = s.split("=");
            tree.put(split[0], split.length > 1 ? split[1] : "");
        }

        tree.remove("sig");
        tree.replace("ts", new Date().getTime() / 1000 + "");
        return tree;
    }

    @Test
    public void test_do_sign() {
        System.out.println(MyClass.encode(sort_params()));
    }

    private String replateTime() {
//        return p.replace("action", new Date().getTime() / 1000 + "");
        return p.replace("1565961371", new Date().getTime() / 1000 + "");
    }

    @Test
    public void shouldPostForEntityRequestSuccess() throws UnsupportedEncodingException {
        String url = "https://sandbox.pay.qq.com/cgi-bin/rewardpf/reward_pf_exchange.fcg";//+"?"+replateTime();
        String req=sort_params();
//        req +="&sig="+MyClass.encode2(req+"&key="+key);
        String s = SignUtil.doSign(req + "&key=" + key);
        s= URLEncoder.encode(s,"utf-8");
        req +="&sig="+ s;


        String result = restTemplate.postForObject(url, req, String.class);
        System.out.println("result8 = " + result);
    }


    private String key = "UmiiIupjNEW4spK6sXH2pXzsDf3cidOl";

    private RestTemplate restTemplate = new RestTemplate();
}
