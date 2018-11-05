package com.aimeow.iteastyle.domain.ViewObject;

import com.aimeow.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=true)
public class CompanyInfoVO extends BaseEntity {
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
