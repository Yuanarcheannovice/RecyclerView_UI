package com.xz.ui.dto;

import java.util.List;

/**
 * 待付款实体
 */
public class WaitPayDto {

    /**
     * brandName :
     * createTime : 902505600000
     * deliveryTime : -3515472000000
     * id : 3526C173-FE41-426E-936D-1129816CE51A
     * payAmount : 1
     * payTime : 1888-08-08 00:00:00
     * payWay : 1
     * receiptTime : 902505600000
     * status : 0
     */

    private List<BrandNameDto> brandName;
    private long createTime;
    private long deliveryTime;
    private String id;
    private int payAmount;
    private String payTime;
    private int payWay;
    private long receiptTime;
    private int status;

    public List<BrandNameDto> getBrandName() {
        return brandName;
    }

    public void setBrandName(List<BrandNameDto> brandName) {
        this.brandName = brandName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(long deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public int getPayWay() {
        return payWay;
    }

    public void setPayWay(int payWay) {
        this.payWay = payWay;
    }

    public long getReceiptTime() {
        return receiptTime;
    }

    public void setReceiptTime(long receiptTime) {
        this.receiptTime = receiptTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
