package com.aimeow.iteastyle.service.impl;

import com.aimeow.iteastyle.domain.GetProductShowersVO;
import com.aimeow.iteastyle.domain.ProductShowerVO;
import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.service.ProductShowerService;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ProductShowerServiceImpl implements ProductShowerService {
    @Override
    public Result<GetProductShowersVO> getProductShowers(
            Integer page, Integer pageSize) {
        return null;
    }

    @Override
    public Result<ProductShowerVO> getProductShowerById(
            @NonNull String productShowerId) {
        return null;
    }
}
