package com.aimeow.iteastyle.domain;

import java.util.Date;

import lombok.Data;

@Data
public class PostVO {
    private String id;
    private Integer status;
    private String title;
    private Date gmtCreate;
    private Date gmtModified;
    private String content;
}
