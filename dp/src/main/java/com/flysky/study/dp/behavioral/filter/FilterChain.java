package com.flysky.study.dp.behavioral.filter;

public interface FilterChain extends Filter{
    void addFilter(Filter filter);
}
