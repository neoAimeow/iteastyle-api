package com.aimeow.iteastyle.domain.enums;

public enum OrderStatusEnum {
    Init(1 , "初始化"),
    WaitingForPay(2 , "等待付款"),
    Paid(3 , "待发货"),
    Sent(4 , "待收货"),
    Comment(5 , "待评价"),
    Finish(6 , "已完成"),
    Invalid(-1 , "已失效");

    private Integer value;
    private String description;

    OrderStatusEnum(Integer value ,String description) {
        this.value = value;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
