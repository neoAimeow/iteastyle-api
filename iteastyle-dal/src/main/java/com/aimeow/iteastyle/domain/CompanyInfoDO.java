package com.aimeow.iteastyle.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class CompanyInfoDO {
    @Id
    private String id;
    private String companyInfo;
    private String postCode;
    private String phoneNumber;
    private String telephoneNumber;
    private String mail;
    private String webUrl;
    private String story;
    private String videoUrl;
}
