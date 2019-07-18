package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.entity.Invoice.InvoiceEntity;
import com.aimeow.iteastyle.domain.entity.Invoice.InvoiceTitleEntity;
import com.aimeow.iteastyle.domain.request.CreateInvoiceRequest;
import com.aimeow.iteastyle.domain.request.CreateInvoiceTitleRequest;
import com.aimeow.iteastyle.domain.request.UpdateInvoiceRequest;
import com.aimeow.iteastyle.domain.request.UpdateInvoiceTitleRequest;
import com.aimeow.iteastyle.tools.domain.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "/service",tags = {"通用接口"}, description = "通用的接口数据")
@RequestMapping(value = "/service")
@RestController
public interface InvoiceService {
    @ApiOperation(value = "通过GET请求方式通过userId获取该用户开票信息")
    @RequestMapping(value = "/getInvoiceByInvoiceId", method = RequestMethod.GET)
    BaseResult<InvoiceEntity> getInvoiceByInvoiceId(String invoiceId);

    @ApiOperation(value = "通过GET请求方式通过userId获取该用户发票抬头")
    @RequestMapping(value = "/getInvoiceTitleByInvoiceTitleId", method = RequestMethod.GET)
    BaseResult<InvoiceTitleEntity> getInvoiceTitleByInvoiceTitleId(String invoiceTitleId);

    @ApiOperation(value = "通过GET请求方式通过userId获取该用户开票信息列表")
    @RequestMapping(value = "/getInvoiceByUserId", method = RequestMethod.GET)
    BaseResult<List<InvoiceEntity>> getInvoiceByUserId(String userId);

    @ApiOperation(value = "通过GET请求方式通过userId获取该用户发票抬头列表")
    @RequestMapping(value = "/getInvoiceTitleByUserId", method = RequestMethod.GET)
    BaseResult<List<InvoiceTitleEntity>> getInvoiceTitleByUserId(String userId);

    @ApiOperation(value = "通过POST请求方式创建用户开票信息")
    @RequestMapping(value = "/createInvoice", method = RequestMethod.POST)
    BaseResult<Boolean> createInvoice(CreateInvoiceRequest request);

    @ApiOperation(value = "通过POST请求方式创建用户发票抬头")
    @RequestMapping(value = "/createInvoiceTitle", method = RequestMethod.POST)
    BaseResult<Boolean> createInvoiceTitle(CreateInvoiceTitleRequest request);

    @ApiOperation(value = "通过POST请求方式修改用户开票信息")
    @RequestMapping(value = "/updateInvoice", method = RequestMethod.POST)
    BaseResult<Boolean> updateInvoice(UpdateInvoiceRequest request);

    @ApiOperation(value = "通过POST请求方式修改用户发票抬头")
    @RequestMapping(value = "/updateInvoiceTitle", method = RequestMethod.POST)
    BaseResult<Boolean> updateInvoiceTitle(UpdateInvoiceTitleRequest request);

    @ApiOperation(value = "通过GET请求方式通过userId获取该用户发票抬头")
    @RequestMapping(value = "/getDefaultInvoiceTitle", method = RequestMethod.GET)
    BaseResult<InvoiceTitleEntity> getDefaultInvoiceTitle(String userId);
}
