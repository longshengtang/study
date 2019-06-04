package com.flysky.study.dp.filter;

public interface Filter {
    boolean doFilter(Request request, Response response, FilterChain filterChain);
}