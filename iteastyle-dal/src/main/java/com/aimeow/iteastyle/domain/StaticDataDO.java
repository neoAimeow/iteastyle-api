package com.aimeow.iteastyle.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StaticDataDO implements Serializable {
    private static final long serialVersionUID = 3058517636708388619L;
    private String contactUsTitle;
    private String logoUrl;
    private String companyStoryBgUrl;
    private String productShowerHeaderUrl;
    private String postBgUrl;
    private String contactUsBgUrl;

    private List<String> homepageBannerUrls;
    private List<String> homepageServiceImageUrls;
    private List<String> homepageShowerImageUrls;
}
