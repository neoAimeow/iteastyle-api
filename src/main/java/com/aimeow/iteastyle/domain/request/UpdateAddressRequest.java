package com.aimeow.iteastyle.domain.request;

import lombok.Data;

/**
 * Created on 2018/11/6 11:51 AM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */
@Data
public class UpdateAddressRequest {
    /**
     * 联系人（收件人）
     */
    private String consignee;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 手机号
     */
    private String phoneNo;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String district;
    /**
     * 地址
     */
    private String address;
    /**
     * 地址详情
     */
    private String addressDetail;
    /**
     * 标签
     */
    private String tag;
    /**
     * 是否默认
     */
    private Boolean isDefault;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 经度
     */
    private Double longitude;
}
