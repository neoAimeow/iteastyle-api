package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.domain.StaticDataVO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "StaticData", description = "静态数据相关接口，比如说背景图片链接地址")
@RestController
public interface StaticDataService {
    @RequestMapping(value = "/staticData/getData", method = RequestMethod.GET, consumes="application/json")
    Result<StaticDataVO> getStaticData();
}
