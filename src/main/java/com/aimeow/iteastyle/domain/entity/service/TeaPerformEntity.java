package com.aimeow.iteastyle.domain.entity.service;

import com.aimeow.iteastyle.base.domain.BaseEntity;
import lombok.Data;

@Data
public class TeaPerformEntity extends BaseEntity {
    private String imageUrl;
    private String title;
    private String title_en;
    private String subTitle_en;
    private String iconImageUrl;
}
