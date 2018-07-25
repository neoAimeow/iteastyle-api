package com.aimeow.iteastyle.domain.entity;


import com.aimeow.domain.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class StaticDataEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 3058517636708388619L;
    private String contactUsTitle;
    private String logoUrl;
    private String companyStoryBgUrl;
    private String contactUsBgUrl;

    private List<String> homepageBannerUrls;
    private List<String> homepageServiceImageUrls;
    private List<Map<String , String>> homepageServiceWapInfos;
    private List<String> homepageShowerImageUrls;
}
