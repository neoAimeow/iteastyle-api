package com.aimeow.iteastyle.manager;

import com.aimeow.iteastyle.domain.ProductShowerBO;
import com.aimeow.iteastyle.domain.Result;

import java.util.List;

public interface ProductShowerManager {
    Result<List<ProductShowerBO>> getProductShowerList(
            Integer status , Integer page , Integer pageSize
    ) throws Exception;

    Result<ProductShowerBO> getProductShowerById(String productShowerId) throws Exception;

    Result<Long> countProductShower(Integer status) throws Exception;

    Result<Boolean> createProductShower(ProductShowerBO productShowerBO) throws Exception;
    Result<Boolean> updateProductShower(ProductShowerBO productShowerBO) throws Exception;
    Result<Boolean> deleteProductShower(String productShowerId) throws Exception;
}
