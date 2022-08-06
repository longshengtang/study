package com.flysky.study.springweb.restfull;

import org.junit.Before;
import org.junit.Test;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TencentServiceTest {
    private final TencentService tencentService = new TencentService();

    private String key = "UmiiIupjNEW4spK6sXH2pXzsDf3cidOl";

    private Map<String, String> param;

    @Before
    public void setUp() {
        param = constructParameters();
    }

    /**
     * 构造请求参数
     * @return
     */
    private Map<String, String> constructParameters() {
        Map<String, String> param = new HashMap<>();
        param.put("action", "direct_proivde");
        param.put("contract_no", "Test-888-CCH-20190521-01");
        param.put("offer_id", "1450016120");
        param.put("out_trade_no", "ja201906195300220476180303948");
        param.put("product_id", "txspvip_1month");
        param.put("provide_uin", "358877431");
        param.put("sale_price", "1000");
        param.put("sub_channel_id", "other");
        param.put("ts", "1564406112");//时间戳
        param.put("user_id", "default");
        param.put("user_id_type", "default");
        param.put("user_name", "default");
        param.put("version", "1.0");
        return param;
    }

    /**
     * 拼接签名原串
     */
    @Test
    public void test_sorted_content() {
        String actual = tencentService.sortedContent(param);
        String expected = "action=direct_proivde&contract_no=Test-888-CCH-20190521-01&offer_id=1450016120&out_trade_no=ja201906195300220476180303948&product_id=txspvip_1month&provide_uin=358877431&sale_price=1000&sub_channel_id=other&ts=1564406112&user_id=default&user_id_type=default&user_name=default&version=1.0";
        assertThat(actual).isEqualTo(expected);
    }

    /**
     * 计算SHA256摘要
     */
    @Test
    public void test_sha256() throws Exception {
        String sortedContent = tencentService.sortedContent(param);
        byte[] bytes = SHACoder.encodeSHA256(sortedContent + "&" + key);
        String actual = SHACoder.encodeHexString(bytes);
        String expected = "a170d46aef3c5b9524b5107a3933c70b421a01195765084f7a1a0f406f0ded08";
        assertThat(actual).isEqualTo(expected);
        assertThat(SHACoder.encodeSHA256Hex(sortedContent + "&" + key)).isEqualTo(expected);
    }

    /**
     * 计算RSA签名
     */
    @Test
    public void doSign() throws Exception {
        String sortedContent = tencentService.sortedContent(param);
        String actual = SignUtil.doSign(sortedContent + "&" + key);
        String expected = "QficxFhJbJ4dwHYjLaUYnzl6xLnOOfQh+AYL9IysVkj06NyrCH49diSg2XTtUvq9LC3e9HN+pitIb6HUVRXdR1yo9fiisQdL9YRielmAdmWKR0pplc/ZeeuTEJUn+aiS0ZL6e3UGTOTIjsmcdoqGFgsjmoto4N+iz84RYl3Aswn/39coiRuk3Qu5yhbF8xGVt3Bx60LPEunrfpJc3rjCTDHkMS2jXwJyilK1rjHXK6h6soUaZfT9EublPwQ2vFIFIut3fy2sFs9mcBy4fFM4SArMhp2LMQyMkbrLYlSOg59nHkxunJWRW0a1PU8G8VH/M1DUap5IVQR3h/+dOicq/w==";
        assertThat(actual).isEqualTo(expected);

        String actualUrlEncode = URLEncoder.encode(actual, "utf-8");
        String expectedUrlEncode = "QficxFhJbJ4dwHYjLaUYnzl6xLnOOfQh%2BAYL9IysVkj06NyrCH49diSg2XTtUvq9LC3e9HN%2BpitIb6HUVRXdR1yo9fiisQdL9YRielmAdmWKR0pplc%2FZeeuTEJUn%2BaiS0ZL6e3UGTOTIjsmcdoqGFgsjmoto4N%2Biz84RYl3Aswn%2F39coiRuk3Qu5yhbF8xGVt3Bx60LPEunrfpJc3rjCTDHkMS2jXwJyilK1rjHXK6h6soUaZfT9EublPwQ2vFIFIut3fy2sFs9mcBy4fFM4SArMhp2LMQyMkbrLYlSOg59nHkxunJWRW0a1PU8G8VH%2FM1DUap5IVQR3h%2F%2BdOicq%2Fw%3D%3D";
        assertThat(actualUrlEncode).isEqualTo(expectedUrlEncode);
    }

    /**
     * 测试物品交换
     */
    @Test
    public void rewardPfExchange() {
        //旧的时间戳
        assertThat(param).containsEntry("ts","1564406112");
        String result = tencentService.rewardPfExchange(param);//时间戳无效
        assertThat(result).contains("{\"ret\" : 1001,\"err_code\" : \"\",\"msg\" : \"请求参数错误(ts not valid: 1564406112");

        //修改当前时间戳
        param.put("ts", new Date().getTime() / 1000 + "");
        result = tencentService.rewardPfExchange(param);
        //公钥需要传递给腾讯平台方
        assertThat(result).isEqualTo("{\"ret\" : 1001,\"err_code\" : \"\",\"msg\" : \"请求参数错误(sig error)\"}");
    }
}
