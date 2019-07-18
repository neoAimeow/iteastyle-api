package com.aimeow.iteastyle.domain.ViewObject;

import com.aimeow.iteastyle.tools.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CompanyStoryVO extends BaseEntity {
    private String storyTitle;
    private String storyContent;
    private String videoUrl;
    private String backgroundImageUrl;
}
