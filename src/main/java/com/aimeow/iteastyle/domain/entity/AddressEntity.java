package com.aimeow.iteastyle.domain.entity;

import com.aimeow.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class AddressEntity extends BaseEntity {
    /** 对应的userId */
    private String userId;
    /** 联系人（收件人） */
    private String consignee;
    /** 性别 */
    private Integer gender;
    /** 手机号 */
    private String phoneNo;
    /** 省 */
    private String province;
    /** 市 */
    private String city;
    /** 区 */
    private String district;
    /** 地址 */
    private String address;
    /** 地址详情 */
    private String addressDetail;
    /** 标签 */
    private String tag;
    /** 是否默认 */
    private Boolean isDefault;
    /** 纬度 */
    private Double latitude;
    /** 经度 */
    private Double longitude;
}
