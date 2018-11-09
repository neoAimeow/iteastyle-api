package com.aimeow.iteastyle.service.impl;

import com.aimeow.domain.BaseResult;
import com.aimeow.iteastyle.domain.entity.Invoice.InvoiceEntity;
import com.aimeow.iteastyle.domain.entity.Invoice.InvoiceTitleEntity;
import com.aimeow.iteastyle.domain.query.InvoiceTitleQuery;
import com.aimeow.iteastyle.domain.request.CreateInvoiceRequest;
import com.aimeow.iteastyle.domain.request.CreateInvoiceTitleRequest;
import com.aimeow.iteastyle.domain.request.UpdateInvoiceRequest;
import com.aimeow.iteastyle.domain.request.UpdateInvoiceTitleRequest;
import com.aimeow.iteastyle.service.InvoiceService;
import com.aimeow.tools.CommonDAO;
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
        return null;
    }

    @Override
    public BaseResult<Boolean> createInvoice(CreateInvoiceRequest request) {
        return null;
    }

    @Override
    public BaseResult<Boolean> createInvoiceTitle(CreateInvoiceTitleRequest request) {
        return null;
    }

    @Override
    public BaseResult<Boolean> updateInvoice(UpdateInvoiceRequest request) {
        return null;
    }

    @Override
    public BaseResult<Boolean> updateInvoiceTitle(UpdateInvoiceTitleRequest request) {
        return null;
    }
}
