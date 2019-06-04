package com.flysky.study.dp.behavioral.filter;

public interface Filter {
    boolean doFilter(Request request, Response response, FilterChain filterChain);
}