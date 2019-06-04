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
        return filter.doFilter(request, response, this);//请注意，不要使用方法参数filterChain，而要使用this，否则当链中的命令包含FilterChain类型时候，只会被当成Command类型执行
    }

    @Override
    public void addFilter(Filter filter) {
        this.filters.add(filter);
    }
}