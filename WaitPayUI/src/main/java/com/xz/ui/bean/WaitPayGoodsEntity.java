package com.xz.ui.bean;

import com.xz.ui.dto.ProductDetailsDto;

/**
 * Created by Administrator on 2018/8/30.
 */

public class WaitPayGoodsEntity {
    private int buySum;
    private String id;
    private String imgUrl;
    private int price;
    private String productName;
    private String specAName;
    private String specBName;

    public static WaitPayGoodsEntity newInstance(ProductDetailsDto pdd){
        WaitPayGoodsEntity waitPayGoodsEntity=new WaitPayGoodsEntity();
        waitPayGoodsEntity.setId(pdd.getId());
        waitPayGoodsEntity.setBuySum(pdd.getBuySum());
        waitPayGoodsEntity.setImgUrl(pdd.getImgUrl());
        waitPayGoodsEntity.setPrice(pdd.getPrice());
        waitPayGoodsEntity.setProductName(pdd.getProductName());
        waitPayGoodsEntity.setSpecAName(pdd.getSpecAName());
        waitPayGoodsEntity.setSpecBName(pdd.getSpecBName());
        return  waitPayGoodsEntity;
    }

    public int getBuySum() {
        return buySum;
    }

    public void setBuySum(int buySum) {
        this.buySum = buySum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSpecAName() {
        return specAName;
    }

    public void setSpecAName(String specAName) {
        this.specAName = specAName;
    }

    public String getSpecBName() {
        return specBName;
    }

    public void setSpecBName(String specBName) {
        this.specBName = specBName;
    }
}
