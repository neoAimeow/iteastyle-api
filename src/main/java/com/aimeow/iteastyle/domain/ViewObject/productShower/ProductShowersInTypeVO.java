package com.aimeow.iteastyle.domain.ViewObject.productShower;

import java.util.List;

import lombok.Data;

@Data
public class ProductShowersInTypeVO {
    private ProductShowerTypeVO productType;
    private List<ProductShowerBaseVO> productShowers;
}
