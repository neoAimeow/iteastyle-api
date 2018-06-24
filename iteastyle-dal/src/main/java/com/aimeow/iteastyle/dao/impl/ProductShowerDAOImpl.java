package com.aimeow.iteastyle.dao.impl;

import com.aimeow.iteastyle.dao.ProductShowerDAO;
import com.aimeow.iteastyle.domain.ProductShowerDO;
import com.aimeow.iteastyle.domain.query.ProductShowerQuery;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ProductShowerDAOImpl implements ProductShowerDAO {
    @Autowired private MongoTemplate mongoTemplate;

    @Override
    public List<ProductShowerDO> queryProductShowers(
            @NonNull ProductShowerQuery productShowerQuery) {
        Query query=new Query();
        query.with(new Sort(Sort.Direction.DESC, "gmtModified"));
        query.skip((productShowerQuery.getPage()-1) * productShowerQuery.getPageSize())
                .limit(productShowerQuery.getPageSize());
        List<ProductShowerDO> productShowerDOS =  mongoTemplate.find(
                query , ProductShowerDO.class
        );
        return productShowerDOS;
    }

    @Override
    public ProductShowerDO queryProductShowerById(
            @NonNull ProductShowerQuery showerQuery) {
        Query query=new Query(Criteria.where("id").is(
                showerQuery.getProductShowerId()));
        ProductShowerDO post =  mongoTemplate.findOne(
                query , ProductShowerDO.class
        );
        return post;
    }

    @Override
    public Long countProductShower(
            @NonNull ProductShowerQuery productShowerQuery) {
        Query query=new Query();
        return mongoTemplate.count(query, ProductShowerDO.class);
    }

    @Override
    public Boolean createProductShower(
            @NonNull ProductShowerDO productShowerDO) {
        productShowerDO.setGmtCreate(new Date());
        productShowerDO.setGmtModified(new Date());
        mongoTemplate.save(productShowerDO);
        return true;
    }

    @Override
    public Boolean updateProductShower(
            @NonNull ProductShowerDO productShowerDO) {
        return null;
    }

    @Override
    public Boolean deleteProductShowerById(
            @NonNull String productShowerId) {
        Query query=new Query(Criteria.where("id").is(productShowerId));
        mongoTemplate.remove(query,ProductShowerDO.class);
        return true;
    }

}
