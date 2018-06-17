package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.GetProductShowersVO;
import com.aimeow.iteastyle.domain.ProductShowerVO;
import com.aimeow.iteastyle.domain.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/productShower", tags = {"产品展示"},description = "产品展示相关接口")
@RequestMapping(value = "/productShower", consumes="application/json")
@RestController
public interface ProductShowerService {

    @ApiOperation(value = "通过产品展示ID获取经典案例内容")
    @RequestMapping(value = "/productShowerById", method = RequestMethod.GET)
    Result<ProductShowerVO> getProductShowerById(String productShowerId);

    @ApiOperation(value = "通过分页参数获得产品展示列表")
    @RequestMapping(value = "/productShowers", method = RequestMethod.GET)
    Result<GetProductShowersVO> getProductShowers(Integer page , Integer pageSize);
}
