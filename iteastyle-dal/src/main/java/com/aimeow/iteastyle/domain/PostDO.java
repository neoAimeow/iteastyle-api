package com.aimeow.iteastyle.domain;

import java.util.Date;

import lombok.Data;

@Data
public class PostDO {
    private String title;
    private Date gmt_create;
    private Date gmt_modified;
    private String content;
}
