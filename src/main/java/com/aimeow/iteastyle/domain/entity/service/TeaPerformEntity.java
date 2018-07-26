package com.aimeow.iteastyle.domain.entity.service;

import com.aimeow.domain.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
//已经废弃
public class TeaPerformEntity extends BaseEntity {
    private String iconImageUrl;
    private String title;
    private String title_en;
    private List<String> imageUrls;
}
