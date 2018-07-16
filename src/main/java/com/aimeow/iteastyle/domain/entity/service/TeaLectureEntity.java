package com.aimeow.iteastyle.domain.entity.service;

import com.aimeow.iteastyle.base.domain.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class TeaLectureEntity extends BaseEntity {
    private String title;
    private String title_en;
    private String iconImageUrl;
    private List<String> imageUrls;
}
