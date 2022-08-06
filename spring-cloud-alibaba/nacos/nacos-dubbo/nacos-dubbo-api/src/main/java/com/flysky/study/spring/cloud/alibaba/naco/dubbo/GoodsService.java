package com.flysky.study.spring.cloud.alibaba.naco.dubbo;

public interface GoodsService {
    /**
     * 通过ID查询商品详情
     * @param id 商品ID
     * @return 返回结果
     */
    GoodsDetailDTO findGoodsById(Long id);
}
