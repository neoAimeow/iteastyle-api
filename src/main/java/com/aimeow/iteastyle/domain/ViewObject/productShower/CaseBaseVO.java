package com.aimeow.iteastyle.domain.ViewObject.productShower;

import com.aimeow.iteastyle.base.domain.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class CaseBaseVO extends BaseEntity {
    private String title;
    private Integer type;
    private String typeName;
    private List<String> imageArr;
    private String content;
}