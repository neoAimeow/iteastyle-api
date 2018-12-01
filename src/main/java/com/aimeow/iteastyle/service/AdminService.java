package com.aimeow.iteastyle.service;

import com.aimeow.domain.BaseResult;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/admin",tags = {"管理接口"}, description = "管理相关各路接口")
@RequestMapping(value = "/admin")
@RestController
public interface AdminService {

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    BaseResult<Boolean> create(String param, String type);

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    BaseResult<Boolean> update(String param, String type);

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    BaseResult<Boolean> delete(String id, String type);

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    BaseResult<JSONObject> getInfo(String type);

    @RequestMapping(value = "/updateData", method = RequestMethod.POST)
    BaseResult<Boolean> updateData(String param, String type);

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    BaseResult<String> getList(Integer page , Integer pageSize , String type);

}
