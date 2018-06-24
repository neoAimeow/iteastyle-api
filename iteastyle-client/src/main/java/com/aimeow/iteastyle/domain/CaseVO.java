package com.aimeow.iteastyle.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CaseVO {
    private String id;
    private String title;
    private Integer type;
    private String typeName;
    private List<String> imageArr;
    private Date gmtCreate;
    private Date gmtModified;
}
