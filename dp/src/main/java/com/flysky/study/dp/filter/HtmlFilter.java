package com.flysky.study.dp.filter;

public class HtmlFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        String src = request.getMsg();
        src = src.replaceAll("<script>", "[script]");
        request.setMsg(src);
        if(filterChain.doFilter(request, response, filterChain)){
            response.setData(response.getData()+"---Html");
            return true;
        }

        return false;
    }
}
