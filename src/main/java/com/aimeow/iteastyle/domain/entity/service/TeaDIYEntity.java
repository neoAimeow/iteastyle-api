package com.aimeow.iteastyle.domain.entity.service;

import com.aimeow.domain.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class TeaDIYEntity extends BaseEntity {
    private String iconImageUrl;
    private String title;
    private String title_en;
    private List<String> imageUrls;
}