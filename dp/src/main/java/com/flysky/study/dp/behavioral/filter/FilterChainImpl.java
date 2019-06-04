package com.flysky.study.dp.behavioral.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChainImpl implements FilterChain {

    private List<Filter> filters = new ArrayList<>();
    private int index = 0;

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        if (index == filters.size()) {
            return true;
        }
        Filter filter = filters.get(index++);
        return filter.doFilter(request, response, this);
    }

    @Override
    public void addFilter(Filter filter) {
        this.filters.add(filter);
    }
}