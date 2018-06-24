package com.aimeow.iteastyle.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document
public class CompanyInfoDO implements Serializable {
    private static final long serialVersionUID = 8471287997901469057L;
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
