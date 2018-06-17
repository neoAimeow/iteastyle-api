package com.aimeow.iteastyle.dao.impl;

import com.aimeow.iteastyle.dao.ProductShowerDAO;
import com.aimeow.iteastyle.domain.ProductShowerDO;
import com.aimeow.iteastyle.domain.query.ProductShowerQuery;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductShowerDAOImpl implements ProductShowerDAO {
    @Override
    public List<ProductShowerDO> queryProductShowers(
            @NonNull ProductShowerQuery query) {
        return null;
    }

    @Override
    public ProductShowerDO queryProductShowerById(
            @NonNull ProductShowerQuery query) {
        return null;
    }

    @Override
    public Long countProductShower(
            @NonNull ProductShowerQuery query) {
        return null;
    }

    @Override
    public Boolean createProductShower(
            @NonNull ProductShowerDO productShowerDO) {
        return null;
    }

    @Override
    public Boolean updateProductShower(
            @NonNull ProductShowerDO productShowerDO) {
        return null;
    }

    @Override
    public Boolean deleteProductShowerById(
            @NonNull String productShowerId) {
        return null;
    }

}
