package com.aimeow.iteastyle.domain.ViewObject;

import com.aimeow.iteastyle.tools.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper=true)
public class StaticDataVO extends BaseEntity {
    private String contactUsTitle;
    private String logoUrl;
    private String companyStoryBgUrl;
    private String productShowerHeaderUrl;
    private String postBgUrl;
    private String contactUsBgUrl;

    private List<String> homepageBannerUrls;
    private List<String> homepageServiceImageUrls;
    private List<Map<String , String>> homepageServiceWapInfos;
    private List<String> homepageShowerImageUrls;
}
