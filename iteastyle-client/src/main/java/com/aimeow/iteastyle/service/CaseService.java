package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.CaseVO;
import com.aimeow.iteastyle.domain.GetCasesVO;
import com.aimeow.iteastyle.domain.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/case", tags = {"经典案例"},description = "经典案例相关接口")
@RequestMapping(value = "/case")
@RestController
public interface CaseService {

    @ApiOperation(value = "通过经典案例ID获取经典案例内容")
    @RequestMapping(value = "/getCaseById", method = RequestMethod.GET, consumes="application/json")
    Result<CaseVO> getCaseById(String caseId);

    @ApiOperation(value = "通过分页参数获得经典案例列表")
    @RequestMapping(value = "/cases", method = RequestMethod.GET, consumes="application/json")
    Result<GetCasesVO> getCases(Integer page , Integer pageSize);
}
