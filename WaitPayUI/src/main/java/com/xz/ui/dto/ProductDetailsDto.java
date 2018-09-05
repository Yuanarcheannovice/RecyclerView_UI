package com.xz.ui.dto;

/**
 * 商品实体
 */
public class ProductDetailsDto {

    /**
     * buySum : 10
     * id : dsaddsada
     * imgUrl : http://192.168.10.198:8080/tianbamalllong.png
     * price : 100
     * productName : 测试A
     * specAName : 王测试
     * specBName : dasdas
     */

    private int buySum;
    private String id;
    private String imgUrl;
    private int price;
    private String productName;
    private String specAName;
    private String specBName;

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
