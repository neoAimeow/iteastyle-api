package com.aimeow.iteastyle.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;
import com.aimeow.tools.RedisUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WxConfig {
    @Autowired private RedisUtil redisUtil;

    @Bean
    public WxMaConfig wxMaConfig() {
        WxMaInMemoryConfig config = new WxMaInMemoryConfig();
        JSONObject setting = JSONObject.parseObject(redisUtil.get("iteastyle-wx-setting"));
        config.setAppid(setting.getString("appId"));
        config.setSecret(setting.getString("appSecret"));
        return config;
    }


    @Bean
    public WxMaService wxMaService(WxMaConfig maConfig) {
        WxMaService service = new WxMaServiceImpl();
        service.setWxMaConfig(maConfig);
        return service;
    }

    @Bean
    public WxPayConfig wxPayConfig() {
        WxPayConfig payConfig = new WxPayConfig();

        JSONObject setting = JSONObject.parseObject(redisUtil.get("iteastyle-wx-setting"));

        payConfig.setAppId(setting.getString("appId"));
        payConfig.setMchId(setting.getString("mchId"));
        payConfig.setMchKey(setting.getString("mchKey"));
        payConfig.setNotifyUrl(setting.getString("notifyUrl"));
        payConfig.setTradeType("JSAPI");
        payConfig.setSignType("MD5");
        return payConfig;
    }


    @Bean
    public WxPayService wxPayService(WxPayConfig payConfig) {
        WxPayService wxPayService = new WxPayServiceImpl();
        wxPayService.setConfig(payConfig);
        return wxPayService;
    }
}