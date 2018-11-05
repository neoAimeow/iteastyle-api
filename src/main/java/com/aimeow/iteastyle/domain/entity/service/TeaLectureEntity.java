package com.aimeow.iteastyle.domain.entity.service;

import com.aimeow.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper=true)
@Data
public class TeaLectureEntity extends BaseEntity {
    private String title;
    private String title_en;
    private String iconImageUrl;
    private List<String> imageUrls;
}
