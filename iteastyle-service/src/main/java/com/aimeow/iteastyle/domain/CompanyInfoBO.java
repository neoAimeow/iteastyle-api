package com.aimeow.iteastyle.domain;

import lombok.Data;

@Data
public class CompanyInfoBO {
    private String companyName;
    private String companyAddress;
    private String postCode;
    private String phoneNumber;
    private String telephoneNumber;
    private String mail;
    private String webUrl;
    private String storyTitle;
    private String story;
    private String videoUrl;
    private Double latitude;
    private Double longitude;
}
