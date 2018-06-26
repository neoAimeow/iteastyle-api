package com.aimeow.iteastyle.converter;

import com.aimeow.iteastyle.domain.ProductShowerBO;
import com.aimeow.iteastyle.domain.ProductShowerDO;
import com.aimeow.iteastyle.domain.ProductShower.ProductShowerVO;
import lombok.NonNull;

public class ProductShowerConverter {
    public static ProductShowerBO convertDTB(ProductShowerDO productShowerDO) {
        ProductShowerBO productShowerBO = new ProductShowerBO();
        productShowerBO.setId(productShowerDO.getId());
        productShowerBO.setTitle(productShowerDO.getTitle());
        productShowerBO.setContent(productShowerDO.getContent());
        productShowerBO.setImageArr(productShowerDO.getImageArr());
        productShowerBO.setGmtCreate(productShowerDO.getGmtCreate());
        productShowerBO.setGmtModified(productShowerDO.getGmtModified());
        productShowerBO.setContent(productShowerDO.getContent());
        return productShowerBO;
    }

    public static ProductShowerDO convertBTD(ProductShowerBO productShowerBO) {
        ProductShowerDO productShowerDO = new ProductShowerDO();
        productShowerDO.setId(productShowerBO.getId());
        productShowerDO.setTitle(productShowerBO.getTitle());
        productShowerDO.setContent(productShowerBO.getContent());
        productShowerDO.setImageArr(productShowerBO.getImageArr());
        productShowerDO.setGmtCreate(productShowerBO.getGmtCreate());
        productShowerDO.setGmtModified(productShowerBO.getGmtModified());
        productShowerDO.setContent(productShowerBO.getContent());
        return productShowerDO;
    }

    public static ProductShowerVO convertBTV(
            @NonNull ProductShowerBO productShowerBO) {
        ProductShowerVO productShowerVO = new ProductShowerVO();
        productShowerVO.setId(productShowerBO.getId());
        productShowerVO.setTitle(productShowerBO.getTitle());
        productShowerVO.setContent(productShowerBO.getContent());
        productShowerVO.setImageArr(productShowerBO.getImageArr());
        productShowerVO.setGmtCreate(productShowerBO.getGmtCreate());
        productShowerVO.setGmtModified(productShowerBO.getGmtModified());
        productShowerVO.setContent(productShowerBO.getContent());
        return productShowerVO;
    }
}
