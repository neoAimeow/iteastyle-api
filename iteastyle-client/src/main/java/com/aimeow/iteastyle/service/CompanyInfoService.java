package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.CompanyInfoVO;
import com.aimeow.iteastyle.domain.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "CompanyInfo", description = "公司信息相关接口")
@RestController
public interface CompanyInfoService {
    @ApiOperation(value = "通过GET请求方式获取公司基本信息，不需要传任何参数")
    @RequestMapping(value = "/company/getInfo", method = RequestMethod.GET, consumes="application/json")
    Result<CompanyInfoVO> getCompanyInfo();
}
