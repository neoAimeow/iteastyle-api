package com.aimeow.iteastyle.domain.entity.Invoice;

import com.aimeow.iteastyle.tools.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class InvoiceEntity extends BaseEntity {
    private String userId;
    private String addressId;
    private String InvoiceTitleId;
    /** 订单号 */
    private String orderId;
    /** 开票金额 */
    private Long amount;
    /** InvoiceStatusEnum */
    private Integer status;
    /** 选择的快递公司 */
    private String courierCompany;
    /** 快递单号 */
    private String courierNumber;
}
