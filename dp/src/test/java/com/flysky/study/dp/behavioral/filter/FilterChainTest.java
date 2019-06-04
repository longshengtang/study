package com.flysky.study.dp.behavioral.filter;

import org.junit.Test;

public class FilterChainTest {

    @Test
    public void test() {

        FilterChain filterChain = new FilterChainImpl();

        filterChain.addFilter(new HtmlFilter());
//        filterChain.addFilter(new SensitiveFilter());


        FilterChain filterChain2 = new FilterChainImpl();

        filterChain2.addFilter(new FaceFilter());
        filterChain2.addFilter(new SensitiveFilter());
        filterChain.addFilter(filterChain2);

        String src = "abc<script>+黄色地板</script>哈喽，您好-_-";

        Request request = new Request();
        request.setMsg(src);
        Response response = new Response();

        filterChain.doFilter(request, response, filterChain);

        System.out.println(request);
    }

}
