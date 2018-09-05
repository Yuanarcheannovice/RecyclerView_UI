package com.xz.ui.dto;

import java.util.List;

/**
 * 返回对象实体
 */
public class WaitPayResponseDto {

    /**
     * code : 0
     * msg : 请求成功!
     * data :
     */

    private int code;
    private String msg;
    private List<WaitPayDto> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<WaitPayDto> getData() {
        return data;
    }

    public void setData(List<WaitPayDto> data) {
        this.data = data;
    }
}
