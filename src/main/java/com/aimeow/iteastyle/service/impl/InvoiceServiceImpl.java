package com.aimeow.iteastyle.service.impl;

import com.aimeow.domain.BaseResult;
import com.aimeow.iteastyle.domain.entity.Invoice.InvoiceEntity;
import com.aimeow.iteastyle.domain.entity.Invoice.InvoiceTitleEntity;
import com.aimeow.iteastyle.domain.request.CreateInvoiceRequest;
import com.aimeow.iteastyle.domain.request.CreateInvoiceTitleRequest;
import com.aimeow.iteastyle.domain.request.UpdateInvoiceRequest;
import com.aimeow.iteastyle.domain.request.UpdateInvoiceTitleRequest;
import com.aimeow.iteastyle.service.InvoiceService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvoiceServiceImpl implements InvoiceService {
    @Override
    public BaseResult<InvoiceEntity> getInvoiceByInvoiceId(String invoiceId) {
        return null;
    }

    @Override
    public BaseResult<InvoiceTitleEntity> getDefaultInvoiceTitle(String userId) {
        return null;
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
