package com.xz.ui.bean;

/**
 * Created by Administrator on 2018/8/30.
 */

public class WaitPayNoOrderEntity {
    private long id;
    private int itemType;

    public WaitPayNoOrderEntity() {
    }

    public WaitPayNoOrderEntity(int itemType) {
        this.itemType = itemType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }
}
