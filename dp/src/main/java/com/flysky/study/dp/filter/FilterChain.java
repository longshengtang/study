package com.flysky.study.dp.filter;

public interface FilterChain extends Filter{
    void addFilter(Filter filter);
}
