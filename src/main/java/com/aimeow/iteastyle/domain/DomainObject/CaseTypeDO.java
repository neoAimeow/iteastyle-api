package com.aimeow.iteastyle.domain.DomainObject;

import com.aimeow.iteastyle.base.domain.BaseEntity;
import lombok.Data;

@Data
public class CaseTypeDO extends BaseEntity {
    private Integer type;
    private String typeName;
    private String typeNameEn;
    private String typeImage;
    private String typeIcon;
}

