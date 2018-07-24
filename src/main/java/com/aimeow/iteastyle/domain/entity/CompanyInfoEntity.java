package com.aimeow.iteastyle.domain.entity;

import com.aimeow.domain.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Document
public class CompanyInfoEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 8471287997901469057L;
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
    private String qrCodeImageUrl;
    private String customerQrCodeImageUrl;
}