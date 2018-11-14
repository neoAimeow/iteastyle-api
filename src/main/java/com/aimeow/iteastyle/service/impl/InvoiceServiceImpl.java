package com.aimeow.iteastyle.service.impl;

import com.aimeow.domain.BaseResult;
import com.aimeow.iteastyle.domain.entity.Invoice.InvoiceEntity;
import com.aimeow.iteastyle.domain.entity.Invoice.InvoiceTitleEntity;
import com.aimeow.iteastyle.domain.enums.InvoiceTitleTypeEnum;
import com.aimeow.iteastyle.domain.query.InvoiceTitleQuery;
import com.aimeow.iteastyle.domain.request.CreateInvoiceRequest;
import com.aimeow.iteastyle.domain.request.CreateInvoiceTitleRequest;
import com.aimeow.iteastyle.domain.request.UpdateInvoiceRequest;
import com.aimeow.iteastyle.domain.request.UpdateInvoiceTitleRequest;
import com.aimeow.iteastyle.service.InvoiceService;
import com.aimeow.tools.CommonDAO;
import com.aimeow.tools.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired private CommonDAO commonDAO;

    @Override
    public BaseResult<InvoiceEntity> getInvoiceByInvoiceId(String invoiceId) {
        return null;
    }

    @Override
    public BaseResult<InvoiceTitleEntity> getDefaultInvoiceTitle(String userId) {
        BaseResult<InvoiceTitleEntity> result = new BaseResult<InvoiceTitleEntity>();

        try {
            InvoiceTitleQuery invoiceTitleQuery= new InvoiceTitleQuery();
            invoiceTitleQuery.setUserId(userId);
            invoiceTitleQuery.setIsDefault(true);

            List<InvoiceTitleEntity> invoiceTitleEntities = commonDAO.queryList(
                    invoiceTitleQuery , InvoiceTitleEntity.class, null , null
            );

            if (invoiceTitleEntities != null && !invoiceTitleEntities.isEmpty()) {
                result.setModel(invoiceTitleEntities.get(0));
            } else {
                result.setSuccess(false);
                result.setMsgInfo("没查到默认发票抬头");
                return result;
            }

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<InvoiceTitleEntity> getInvoiceTitleByInvoiceTitleId(String invoiceTitleId) {
        return null;
    }

    @Override
    public BaseResult<List<InvoiceEntity>> getInvoiceByUserId(String userId) {
        return null;
    }

    @Override
    public BaseResult<List<InvoiceTitleEntity>> getInvoiceTitleByUserId(String userId) {
        if (userId == null) {
            return ResultUtil.getFailureResult("缺少必填的参数");
        }
        try {
            return ResultUtil.buildSuccessResult(new BaseResult<>() , null);
        } catch (Exception ex) {
            return ResultUtil.getFailureResult("未知错误");
        }
    }

    @Override
    public BaseResult<Boolean> createInvoice(CreateInvoiceRequest request) {
        return null;
    }

    @Override
    public BaseResult<Boolean> createInvoiceTitle(CreateInvoiceTitleRequest request) {
        if (request.getUserId() == null || request.getInvoiceTitle() == null || request.getType() == null || request.getMailNo() == null) {
            return ResultUtil.getFailureResult("缺少必填的参数");
        }
        if (request.getType().equals(InvoiceTitleTypeEnum.Company.getValue())) {
            if (request.getIdentification() == null) {
                return ResultUtil.getFailureResult("企业单位必须填写纳税人识别号");
            }
        }
        try {
            InvoiceTitleEntity invoiceTitleEntity = new InvoiceTitleEntity();
            invoiceTitleEntity.setType(request.getType());
            invoiceTitleEntity.setUserId(request.getUserId());
            invoiceTitleEntity.setInvoiceTitle(request.getInvoiceTitle());
            invoiceTitleEntity.setIdentification(request.getIdentification());
            invoiceTitleEntity.setMailNo(request.getMailNo());
            invoiceTitleEntity.setAddress(request.getAddress());
            invoiceTitleEntity.setPhoneNo(request.getPhoneNo());
            invoiceTitleEntity.setBankName(request.getBankName());
            invoiceTitleEntity.setBankAccount(request.getBankAccount());
            invoiceTitleEntity.setIsDefault(request.getIsDefault());
            if (request.getIsDefault()) {
                InvoiceTitleEntity updateEntity = new InvoiceTitleEntity();
                updateEntity.setIsDefault(false);
                updateEntity.setUserId(request.getUserId());

                commonDAO.update(updateEntity , InvoiceTitleEntity.class);
            }
            return ResultUtil.buildSuccessResult(new BaseResult<>() , commonDAO.create(invoiceTitleEntity));
        } catch (Exception ex) {
            return ResultUtil.getFailureResult("未知错误");
        }
    }

    @Override
    public BaseResult<Boolean> updateInvoice(UpdateInvoiceRequest request) {
        return null;
    }

    @Override
    public BaseResult<Boolean> updateInvoiceTitle(UpdateInvoiceTitleRequest request) {
        if (request.getUserId() == null || request.getIsDefault() == null
                || request.getInvoiceTitle() == null
                || request.getType() == null
                || request.getMailNo() == null) {
            return ResultUtil.getFailureResult("缺少必填的参数");
        }
        if (request.getType().equals(InvoiceTitleTypeEnum.Company.getValue())) {
            if (request.getIdentification() == null) {
                return ResultUtil.getFailureResult("企业单位必须填写纳税人识别号");
            }
        }
        try {
            InvoiceTitleEntity invoiceTitleEntity = new InvoiceTitleEntity();
            invoiceTitleEntity.setId(request.getId());
            invoiceTitleEntity.setType(request.getType());
            invoiceTitleEntity.setUserId(request.getUserId());
            invoiceTitleEntity.setInvoiceTitle(request.getInvoiceTitle());
            invoiceTitleEntity.setIdentification(request.getIdentification());
            invoiceTitleEntity.setMailNo(request.getMailNo());
            invoiceTitleEntity.setAddress(request.getAddress());
            invoiceTitleEntity.setPhoneNo(request.getPhoneNo());
            invoiceTitleEntity.setBankName(request.getBankName());
            invoiceTitleEntity.setBankAccount(request.getBankAccount());
            invoiceTitleEntity.setIsDefault(request.getIsDefault());

            if (request.getIsDefault()) {
                InvoiceTitleEntity updateEntity = new InvoiceTitleEntity();
                updateEntity.setUserId(request.getUserId());
                updateEntity.setIsDefault(false);
                commonDAO.update(updateEntity , InvoiceTitleEntity.class);
            }
            return ResultUtil.buildSuccessResult(new BaseResult<>() , commonDAO.update(invoiceTitleEntity, InvoiceTitleEntity.class));
        } catch (Exception ex) {
            return ResultUtil.getFailureResult("未知错误");
        }
    }
}
