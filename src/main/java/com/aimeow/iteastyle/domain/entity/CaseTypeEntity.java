package com.aimeow.iteastyle.domain.entity;

import com.aimeow.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CaseTypeEntity extends BaseEntity {
    private Integer rank;
    private Integer type;
    private String typeName;
    private String typeNameEn;
    private String typeImage;
    private String typeIcon;
}

