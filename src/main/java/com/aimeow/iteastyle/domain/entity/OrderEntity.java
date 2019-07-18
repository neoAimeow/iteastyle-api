package com.aimeow.iteastyle.domain.entity;

import com.aimeow.iteastyle.tools.domain.BaseEntity;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class OrderEntity extends BaseEntity {
    private AddressEntity userAddress;
    private ItemEntity itemSnapshot;
    /** OrderStatusEnum */
    private Integer status;
    /** 商品快照 */
    private JSONObject attribute;
}
