package com.flysky.study.spring.cloud.alibaba.naco.dubbo;

import java.io.Serializable;
import java.math.BigDecimal;

public class GoodsDetailDTO implements Serializable {
    private Long id;
    private String name;
    private String goodsName;
    private String goodsNo;
    private int inventory;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GoodsDetailDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getInventory() {
        return inventory;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
