package com.aimeow.iteastyle.domain.ViewObject;

import com.aimeow.domain.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class ContactUsVO extends BaseEntity {
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
    private String qrCodeImageUrl;
    private String customerQrCodeImageUrl;
}
