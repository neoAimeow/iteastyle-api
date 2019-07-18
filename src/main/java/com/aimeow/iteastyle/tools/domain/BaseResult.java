package com.aimeow.iteastyle.tools.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class BaseResult<T> implements Serializable {
    private static final long serialVersionUID = 3440085496479143237L;
    protected boolean success = true;
    protected T model;
    protected String msgCode;
    protected String msgInfo;
}
