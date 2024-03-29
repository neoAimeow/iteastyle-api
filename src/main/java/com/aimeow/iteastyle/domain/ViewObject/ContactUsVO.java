package com.aimeow.iteastyle.domain.ViewObject;

import com.aimeow.iteastyle.tools.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=true)
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
