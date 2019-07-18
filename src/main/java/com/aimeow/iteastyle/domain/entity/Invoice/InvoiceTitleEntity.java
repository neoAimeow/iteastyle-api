package com.aimeow.iteastyle.domain.entity.Invoice;

import com.aimeow.iteastyle.tools.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class InvoiceTitleEntity extends BaseEntity {
    /** InvoiceTitleTypeEnum */
    private Integer type;
    /** 用户id */
    private String userId;
    /** 发票抬头标题 */
    private String invoiceTitle;
    /** 纳税人识别号 */
    private String identification;
    /** 邮箱地址 */
    private String mailNo;
    /** 注册地址（选填） */
    private String address;
    /** 手机号码（选填） */
    private String phoneNo;
    /** 开户银行（选填） */
    private String bankName;
    /** 银行帐号（选填） */
    private String bankAccount;
    /** 是否默认 */
    private Boolean isDefault;
}
