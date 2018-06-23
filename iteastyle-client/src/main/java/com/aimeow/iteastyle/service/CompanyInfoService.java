package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.CompanyInfoVO;
import com.aimeow.iteastyle.domain.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/company", tags = {"公司信息"},description = "公司信息相关接口")
@RequestMapping(value = "/company")
@RestController

public interface CompanyInfoService {
    @ApiOperation(value = "通过GET请求方式获取公司基本信息，不需要传任何参数")
    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    Result<CompanyInfoVO> getCompanyInfo();
}
