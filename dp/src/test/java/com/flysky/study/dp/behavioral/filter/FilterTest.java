package com.flysky.study.dp.behavioral.filter;

import com.flysky.study.dp.behavioral.filter.*;
import org.junit.Test;

public class FilterTest {

    @Test
    public void testHtmlFilter() {
        String src = "abcd<script>";

        Request request = new Request();
        request.setMsg(src);
        Response response = new Response();

        Filter filter = new HtmlFilter();
        filter.doFilter(request, response, NullFilterChainImpl.getInstance());
        System.out.println(response);
    }

    @Test
    public void tesSensitiveFilter() {
        String src = "abcd黄色地板";


        Request request = new Request();
        request.setMsg(src);
        Response response = new Response();

        Filter filter = new SensitiveFilter();
        filter.doFilter(request, response, NullFilterChainImpl.getInstance());
        System.out.println(response);
    }

    @Test
    public void tesFaceFilter() {
        String src = "-_-您好啊";


        Request request = new Request();
        request.setMsg(src);
        Response response = new Response();

        Filter filter = new FaceFilter();
        filter.doFilter(request, response, NullFilterChainImpl.getInstance());
        System.out.println(response);
    }
}
