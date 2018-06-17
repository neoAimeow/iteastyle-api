package com.aimeow.iteastyle.dao;

import com.aimeow.iteastyle.domain.ProductShowerDO;
import com.aimeow.iteastyle.domain.query.ProductShowerQuery;

import java.util.List;

public interface ProductShowerDAO {
    List<ProductShowerDO> queryProductShowers(
            ProductShowerQuery query) throws Exception;
    ProductShowerDO queryProductShowerById(
            ProductShowerQuery query) throws Exception;
    Long countProductShower(
            ProductShowerQuery query) throws Exception;
    Boolean createProductShower(
            ProductShowerDO productShowerDO) throws Exception;
    Boolean updateProductShower(
            ProductShowerDO productShowerDO) throws Exception;
    Boolean deleteProductShowerById(
            String productShowerId) throws Exception;
}
