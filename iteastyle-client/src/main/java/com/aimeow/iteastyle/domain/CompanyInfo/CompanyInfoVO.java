package com.aimeow.iteastyle.domain.CompanyInfo;

import lombok.Data;

import java.util.List;

@Data
public class CompanyInfoVO {
    private String companyName;
    private String companyAddress;
    private String postCode;
    private List<String> phoneNumber;
    private String telephoneNumber;
    private String mail;
    private String webUrl;
    private String storyTitle;
    private String story;
    private String videoUrl;
    private Double latitude;
    private Double longitude;
}
