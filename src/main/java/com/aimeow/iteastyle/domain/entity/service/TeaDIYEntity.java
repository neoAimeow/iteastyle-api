package com.aimeow.iteastyle.domain.entity.service;

import com.aimeow.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=true)
public class TeaDIYEntity extends BaseEntity {
    private String iconImageUrl;
    private String title;
    private String title_en;
    private List<String> imageUrls;
}
