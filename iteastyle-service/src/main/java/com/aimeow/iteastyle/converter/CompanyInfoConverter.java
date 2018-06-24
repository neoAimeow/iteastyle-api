package com.aimeow.iteastyle.converter;

import com.aimeow.iteastyle.domain.CompanyInfoBO;
import com.aimeow.iteastyle.domain.CompanyInfoDO;
import lombok.NonNull;

public class CompanyInfoConverter {
    public static CompanyInfoBO convertDTB(
            @NonNull CompanyInfoDO companyInfoDO) {
        CompanyInfoBO companyInfoBO = new CompanyInfoBO();
        companyInfoBO.setCompanyAddress(companyInfoDO.getCompanyAddress());
        companyInfoBO.setCompanyName(companyInfoDO.getCompanyName());
        companyInfoBO.setPostCode(companyInfoDO.getPostCode());
        companyInfoBO.setPhoneNumber(companyInfoDO.getPhoneNumber());
        companyInfoBO.setTelephoneNumber(
                companyInfoDO.getTelephoneNumber());
        companyInfoBO.setMail(companyInfoDO.getMail());
        companyInfoBO.setWebUrl(companyInfoDO.getWebUrl());
        companyInfoBO.setStoryTitle(companyInfoDO.getStoryTitle());
        companyInfoBO.setStory(companyInfoDO.getStory());
        companyInfoBO.setVideoUrl(companyInfoDO.getVideoUrl());
        companyInfoBO.setLatitude(companyInfoDO.getLatitude());
        companyInfoBO.setLongitude(companyInfoDO.getLongitude());
        return companyInfoBO;
    }

    public static CompanyInfoDO convertBTD(
            @NonNull CompanyInfoBO companyInfoBO) {
        CompanyInfoDO companyInfoDO = new CompanyInfoDO();
        companyInfoDO.setCompanyAddress(companyInfoBO.getCompanyAddress());
        companyInfoDO.setCompanyName(companyInfoBO.getCompanyName());
        companyInfoDO.setPostCode(companyInfoBO.getPostCode());
        companyInfoDO.setPhoneNumber(companyInfoBO.getPhoneNumber());
        companyInfoDO.setTelephoneNumber(
                companyInfoBO.getTelephoneNumber());
        companyInfoDO.setMail(companyInfoBO.getMail());
        companyInfoDO.setWebUrl(companyInfoBO.getWebUrl());
        companyInfoDO.setStoryTitle(companyInfoBO.getStoryTitle());
        companyInfoDO.setStory(companyInfoBO.getStory());
        companyInfoDO.setVideoUrl(companyInfoBO.getVideoUrl());
        companyInfoDO.setLatitude(companyInfoBO.getLatitude());
        companyInfoDO.setLongitude(companyInfoBO.getLongitude());
        return companyInfoDO;
    }

}
