package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.GetProductShowersVO;
import com.aimeow.iteastyle.domain.ProductShowerVO;
import com.aimeow.iteastyle.domain.Result;

public interface ProductShowerService {

    Result<ProductShowerVO> getProductShowerById(String productShowerId);
    Result<GetProductShowersVO> getProducts(Integer page , Integer pageSize);

}
