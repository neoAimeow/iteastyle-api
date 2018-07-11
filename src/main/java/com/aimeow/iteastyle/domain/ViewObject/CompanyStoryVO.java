package com.aimeow.iteastyle.domain.ViewObject;

import com.aimeow.iteastyle.base.domain.BaseEntity;
import lombok.Data;

@Data
public class CompanyStoryVO extends BaseEntity {
    private String storyTitle;
    private String storyContent;
    private String videoUrl;
    private String backgroundImageUrl;
}
