package com.aimeow.iteastyle.manager.impl;

import com.aimeow.iteastyle.converter.ProductShowerConverter;
import com.aimeow.iteastyle.dao.ProductShowerDAO;
import com.aimeow.iteastyle.domain.ProductShowerBO;
import com.aimeow.iteastyle.domain.ProductShowerDO;
import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.domain.query.ProductShowerQuery;
import com.aimeow.iteastyle.manager.ProductShowerManager;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductShowerManagerImpl
        implements ProductShowerManager {

    @Autowired private ProductShowerDAO productShowerDAO;

    @Override
    public Result<ProductShowerBO> getProductShowerById(
            @NonNull String productShowerId) throws Exception {
        Result<ProductShowerBO> result = new Result<>();
        ProductShowerQuery query = new ProductShowerQuery();
        query.setProductShowerId(productShowerId);
        result.setModel(ProductShowerConverter
                .convertDTB(productShowerDAO.queryProductShowerById(query)));
        return result;
    }

    @Override
    public Result<List<ProductShowerBO>> getProductShowerList(
            @NonNull Integer status, Integer page, Integer pageSize) throws Exception {
        Result<List<ProductShowerBO>> result = new Result<>();
        List<ProductShowerBO> productShowerBOS = new ArrayList<>();

        ProductShowerQuery query = new ProductShowerQuery();
        query.setPage((page==null || page==0)?1:page);
        query.setPageSize((pageSize==null || pageSize==0)?6:pageSize);
        query.setStartRow((page-1) * pageSize);
        query.setStatus(status);
        List<ProductShowerDO> productShowerDOS = productShowerDAO.queryProductShowers(query);
        productShowerDOS.iterator().forEachRemaining(
                obj-> {
                    productShowerBOS.add(ProductShowerConverter.convertDTB(obj));
                }
        );
        result.setModel(productShowerBOS);
        return result;
    }

    @Override
    public Result<Long> countProductShower(Integer status) throws Exception{
        Result<Long> result = new Result<>();
        ProductShowerQuery query = new ProductShowerQuery();
        query.setStatus(status);
        result.setModel(productShowerDAO.countProductShower(query));
        return result;
    }

    @Override
    public Result<Boolean> createProductShower(ProductShowerBO productShowerBO) {
        return null;
    }

    @Override
    public Result<Boolean> updateProductShower(ProductShowerBO productShowerBO) {
        return null;
    }

    @Override
    public Result<Boolean> deleteProductShower(String productShowerId) {
        return null;
    }
}
