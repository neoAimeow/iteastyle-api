package com.aimeow.iteastyle.converter;

import com.aimeow.iteastyle.domain.ProductShowerBO;
import com.aimeow.iteastyle.domain.ProductShowerDO;
import com.aimeow.iteastyle.domain.ProductShowerVO;
import lombok.NonNull;

public class ProductShowerConverter {
    public static ProductShowerBO convertDTB(ProductShowerDO productShowerDO) {
        ProductShowerBO productShowerBO = new ProductShowerBO();

        return productShowerBO;
    }

    public static ProductShowerDO convertBTD(ProductShowerBO postBO) {
        ProductShowerDO productShowerDO = new ProductShowerDO();

        return productShowerDO;
    }

    public static ProductShowerVO convertBTV(
            @NonNull ProductShowerBO productShowerBO) {
        ProductShowerVO productShowerVO = new ProductShowerVO();
        return productShowerVO;
    }
}
