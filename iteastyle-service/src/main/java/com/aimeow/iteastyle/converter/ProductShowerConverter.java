package com.aimeow.iteastyle.converter;

import com.aimeow.iteastyle.domain.ProductShowerBO;
import com.aimeow.iteastyle.domain.ProductShowerDO;

public class ProductShowerConverter {
    public static ProductShowerBO convertDTB(ProductShowerDO productShowerDO) {
        ProductShowerBO productShowerBO = new ProductShowerBO();

        return productShowerBO;
    }

    public static ProductShowerDO convertBTD(ProductShowerBO postBO) {
        ProductShowerDO productShowerDO = new ProductShowerDO();

        return productShowerDO;
    }
}
