package com.aimeow.iteastyle.service;

import com.aimeow.domain.BaseResult;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/common",tags = {"通用接口"}, description = "通用的接口数据")
@RequestMapping(value = "/common")
@RestController
public interface CommonService {
    @ApiOperation(value = "通过GET请求方式以及type获取数据")
    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    BaseResult<JSONObject> getDataWithTypeInRedis(String key);
}
