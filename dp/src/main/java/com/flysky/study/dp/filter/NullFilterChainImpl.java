package com.flysky.study.dp.filter;

public class NullFilterChainImpl implements FilterChain {

    private static final NullFilterChainImpl instance = new NullFilterChainImpl();

    public static NullFilterChainImpl getInstance() {
        return instance;
    }

    private NullFilterChainImpl() {
    }

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChain) {
        System.out.println("我是空实现，没有任何逻辑执行");
        return true;
    }

    @Override
    public void addFilter(Filter filter) {
        System.out.println("我是空实现，不会添加filter");
    }
}