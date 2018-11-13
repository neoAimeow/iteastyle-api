package com.aimeow.iteastyle.service.impl;

import com.aimeow.domain.BaseResult;
import com.aimeow.iteastyle.domain.enums.StaticDataEnum;
import com.aimeow.iteastyle.service.CommonService;
import com.aimeow.tools.RedisUtil;
import com.aimeow.tools.ResultUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommonServiceImpl implements CommonService {
    @Autowired private RedisUtil redisUtil;

    @Override
    public BaseResult<JSONObject> getDataWithTypeInRedis(String key) {
        if (key == null) {
            return ResultUtil.getFailureResult("缺少参数");
        }
        try {
            StaticDataEnum staticDataEnum = StaticDataEnum.getEnumByValue(key);
            JSONObject jsonObject = JSONObject.parseObject(redisUtil.get(staticDataEnum.getKey()));
            if (jsonObject == null) {
                return ResultUtil.getFailureResult("parseObject error");
            }
            return ResultUtil.buildSuccessResult(new BaseResult<>() , jsonObject);
        } catch (Exception ex) {
            return ResultUtil.getFailureResult("未知错误，详情请看日志");
        }
    }
}
