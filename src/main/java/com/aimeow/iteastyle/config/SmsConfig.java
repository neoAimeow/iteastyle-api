package com.aimeow.iteastyle.config;

import com.aimeow.tools.MessageSender;
import com.aimeow.tools.RedisUtil;
import com.aimeow.tools.impl.TencentMessageSender;
import com.alibaba.fastjson.JSONObject;
import com.github.qcloudsms.SmsSingleSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SmsConfig {
    @Autowired
    private RedisUtil redisUtil;

    @Bean
    public MessageSender messageSender() {
        JSONObject setting = JSONObject.parseObject(redisUtil.get("iteastyle-wx-setting"));
        Integer tencentSmsAppId = setting.getInteger("tencentSmsAppId");
        String tencentSmsAppKey = setting.getString("tencentSmsAppKey");

        TencentMessageSender tencentMessageSender = new TencentMessageSender();
        tencentMessageSender.setSender(new SmsSingleSender(tencentSmsAppId, tencentSmsAppKey));
        MessageSender service = tencentMessageSender;
        return service;
    }
}
