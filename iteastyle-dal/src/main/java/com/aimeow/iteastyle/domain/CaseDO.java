package com.aimeow.iteastyle.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class CaseDO {
    private String caseId;
    private String title;
    private List<String> imageArr;
    private Date gmt_create;
    private Date gmt_modified;
}
