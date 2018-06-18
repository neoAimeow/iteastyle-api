package com.aimeow.iteastyle.domain;

import lombok.Data;

import java.util.Date;

@Data
public class LogBO {
    private String id;
    private String content;
    private String operator;
    private Date gmtCreate;
    private Date gmtModified;
}
