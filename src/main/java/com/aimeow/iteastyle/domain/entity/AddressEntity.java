package com.aimeow.iteastyle.domain.entity;

import com.aimeow.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class AddressEntity extends BaseEntity {
    /** 联系人（收件人） */
    private String consignee;
    /** 性别 */
    private Integer gender;
    /** 手机号 */
    private String phoneNo;
    /** 地址 */
    private String address;
    /** 地址详情 */
    private String addressDetail;
    /** 标签 */
    private String tag;
    /** 是否默认 */
    private Boolean isDefault;
}
