package com.xz.ui.bean;

import com.xz.ui.dto.LikeListDto;

/**
 * Created by Administrator on 2018/8/30.
 */

public class WaitPayLikeEntity {
    private String id;
    private String img;
    private String name;
    private int originalPrice;
    private int price;

    public static WaitPayLikeEntity newInstance(LikeListDto lld){
        WaitPayLikeEntity waitPayLikeEntity=new WaitPayLikeEntity();
        waitPayLikeEntity.setId(lld.getId());
        waitPayLikeEntity.setImg(lld.getImg());
        waitPayLikeEntity.setName(lld.getName());
        waitPayLikeEntity.setOriginalPrice(lld.getOriginalPrice());
        waitPayLikeEntity.setPrice(lld.getPrice());
        return waitPayLikeEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
