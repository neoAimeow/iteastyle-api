package com.aimeow.iteastyle.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProductShowerVO {
    private String id;
    private List<String> imageArr;
    private String content;
    private Date gmtCreate;
    private Date gmtModified;
}
