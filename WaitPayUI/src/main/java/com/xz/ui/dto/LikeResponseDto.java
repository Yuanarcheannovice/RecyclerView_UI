package com.xz.ui.dto;

import java.util.List;

/**
 * 返回对象实体
 */
public class LikeResponseDto {


    /**
     * code : 成功!
     * data : [{"id":"safsadfdsfsd","img":"http://192.168.10.238:8080/tianbamall/upload/uploadFile/201809/2d07822fc64a48fd906ae0e3ab8ad3a3.jpg","name":"优衣库XX","originalPrice":33,"price":332},{"id":"safsadfdsfsd","img":"http://192.168.10.238:8080/tianbamall/upload/uploadFile/201809/2d07822fc64a48fd906ae0e3ab8ad3a3.jpg","name":"优衣库XX","originalPrice":33,"price":332}]
     */

    private String code;
    private List<LikeListDto> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<LikeListDto> getData() {
        return data;
    }

    public void setData(List<LikeListDto> data) {
        this.data = data;
    }
}
