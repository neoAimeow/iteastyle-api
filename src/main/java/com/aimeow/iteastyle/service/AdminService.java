package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.tools.domain.BaseResult;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/admin")
@RestController
public interface AdminService {

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    BaseResult<Boolean> create(@RequestBody JSONObject jsonObject);

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    BaseResult<Boolean> update(@RequestBody JSONObject jsonObject);

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    BaseResult<Boolean> delete(@RequestBody JSONObject jsonObject);

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    BaseResult<JSONObject> getInfo(String type);

    @RequestMapping(value = "/updateData", method = RequestMethod.POST)
    BaseResult<Boolean> updateData(@RequestBody JSONObject jsonObject);

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    BaseResult getList(Integer page , Integer pageSize , String type);

    @RequestMapping(value = "/getDataById", method = RequestMethod.GET)
    BaseResult getDataById(String id, String type);

}
