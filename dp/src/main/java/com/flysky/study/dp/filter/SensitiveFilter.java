package com.flysky.study.dp.filter;

public class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        String src = request.getMsg();
        src=src.replaceAll("黄色", "**");
        request.setMsg(src);

        if(filterChain.doFilter(request, response, filterChain)){
            response.setData(response.getData()+"---Sensitive");
            return true;
        }

        return false;
    }
}