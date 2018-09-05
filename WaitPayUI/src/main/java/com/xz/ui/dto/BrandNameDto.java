package com.xz.ui.dto;

import java.util.List;

/**
 * 品牌实体
 */
public class BrandNameDto {

    /**
     * brandName : 联想
     * productDetails :
     */

    private String brandName;
    private List<ProductDetailsDto> productDetails;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<ProductDetailsDto> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetailsDto> productDetails) {
        this.productDetails = productDetails;
    }
}
