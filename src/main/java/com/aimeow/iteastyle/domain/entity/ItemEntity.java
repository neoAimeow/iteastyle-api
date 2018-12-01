package com.aimeow.iteastyle.domain.entity;

import com.aimeow.domain.BaseEntity;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=true)
public class ItemEntity extends BaseEntity {
    private String categoryId;
    private String name;
    private String description;
    /** 价格，单位为分 */
    private Integer price;
    /** 商品类型 ItemTypeEnum */
    private String type;
    private List<String> gallery;
    private List<String> tags;
    private String detail;
    /** ItemStatusEnum */
    private Integer status;
    private JSONObject attribute;
}
