package com.aimeow.iteastyle.domain.enums;

public enum InvoiceStatusEnum {
    Prepare(1 , "待寄出"),
    SENT(2 , "已寄出")
    ;
    private Integer value;
    private String description;

    InvoiceStatusEnum(Integer value ,String description) {
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
