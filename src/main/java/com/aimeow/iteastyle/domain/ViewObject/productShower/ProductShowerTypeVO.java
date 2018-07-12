package com.aimeow.iteastyle.domain.ViewObject.productShower;

import com.aimeow.iteastyle.base.domain.BaseEntity;
import lombok.Data;

@Data
public class ProductShowerTypeVO extends BaseEntity {
    private Integer type;
    private String typeName;
    private String typeNameEn;
    private String typeImage;
    private String typeIcon;
}
