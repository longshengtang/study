package com.flysky.study.dp.behavioral.filter;

public class FaceFilter implements Filter {
    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        String src = request.getMsg();
        src = src.replaceAll("-_-", "(^_^)");
        request.setMsg(src);

        if(filterChain.doFilter(request, response, filterChain)){
            response.setData(response.getData()+"---Face");
            return true;
        }

        return false;
    }
}
