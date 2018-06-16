package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.domain.StaticDataVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/staticData", description = "静态数据相关接口，比如说背景图片链接地址")
@RequestMapping(value = "/staticData", consumes="application/json")
@RestController
public interface StaticDataService {
    @ApiOperation(value = "通过GET请求方式获取静态数据相关信息，不需要传任何参数")
    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    Result<StaticDataVO> getStaticData();
}
