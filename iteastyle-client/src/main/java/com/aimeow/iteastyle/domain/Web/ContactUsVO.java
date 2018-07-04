package com.aimeow.iteastyle.domain.Web;

import lombok.Data;

import java.util.List;

@Data
public class ContactUsVO {
    private String contactUsTitle;
    private String contactUsBackgroundImage;
    private String companyName;
    private String companyAddress;
    private String telephoneNumber;
    private List<String> phoneNumber;
    private String mailAddress;
    private String siteAddress;
    private Double latitude;
    private Double longitude;
}
