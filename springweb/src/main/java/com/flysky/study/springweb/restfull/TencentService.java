package com.flysky.study.springweb.restfull;

import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 腾讯服务
 */
public class TencentService {

    /**
     * 物品交换接口：腾讯会员直充等
     */
    public String rewardPfExchange(Map<String, String> param) {
        String requestBody = buildRequestBody(param);
        String result = restTemplate.postForObject(url, requestBody, String.class);
        return result;
    }

    private String buildRequestBody(Map<String, String> param) {
        String sig = SignUtil.doSign(sortedContent(param) + "&=" + key);
        return toUrlParams(param) + "&sig=" + urlEncode(sig);
    }

    public String sortedContent(Map<String, String> param) {
        return toUrlParams(new TreeMap<>(param));
    }

    private String toUrlParams(Map<String, String> tree) {
        return tree.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining("&"));
    }

    private String urlEncode(String sig) {
        try {
            sig = URLEncoder.encode(sig, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return sig;
    }

    //沙箱环境
    String url = "https://sandbox.pay.qq.com/cgi-bin/rewardpf/reward_pf_exchange.fcg";

    private String key = "UmiiIupjNEW4spK6sXH2pXzsDf3cidOl";

    private RestTemplate restTemplate = new RestTemplate();
}
