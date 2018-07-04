package com.aimeow.iteastyle.domain;

import lombok.Data;

import java.util.List;

@Data
public class StaticDataBO {
    private String contactUsTitle;
    private String logoUrl;
    private String companyStoryBgUrl;
    private String productShowerHeaderUrl;
    private String postBgUrl;
    private String contactUsBgUrl;

    private List<String> homepageBannerUrls;
    private List<String> homepageServiceImageUrls;
    private List<String> homepageServiceWapImageUrls;
    private List<String> homepageShowerImageUrls;
}
