package com.aimeow.iteastyle.domain;

import lombok.Data;

@Data
public class CompanyInfoVO {
    private String companyName;
    private String companyAddress;
    private String phoneNumber;
    private String telephoneNumber;
    private String mail;
    private String webUrl;
    private String story;
    private String videoUrl;
    private Double latitude;
    private Double longitude;
}
