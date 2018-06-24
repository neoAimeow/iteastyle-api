package com.aimeow.iteastyle.converter;

import com.aimeow.iteastyle.domain.CompanyInfoBO;
import com.aimeow.iteastyle.domain.CompanyInfoDO;
import com.aimeow.iteastyle.domain.CompanyInfoVO;
import lombok.NonNull;

public class CompanyInfoConverter {
    public static CompanyInfoBO convertDTB(
            @NonNull CompanyInfoDO companyInfoDO) {
        CompanyInfoBO companyInfoBO = new CompanyInfoBO();
        companyInfoBO.setCompanyInfo(companyInfoDO.getCompanyInfo());
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
        companyInfoDO.setCompanyInfo(companyInfoBO.getCompanyInfo());
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

    public static CompanyInfoVO convertBTV(
            @NonNull CompanyInfoBO companyInfoBO) {
        CompanyInfoVO companyInfoVO = new CompanyInfoVO();
        companyInfoVO.setId(companyInfoBO.getId());
        companyInfoVO.setCompanyInfo(companyInfoBO.getCompanyInfo());
        companyInfoVO.setPostCode(companyInfoBO.getPostCode());
        companyInfoVO.setPhoneNumber(companyInfoBO.getPhoneNumber());
        companyInfoVO.setTelephoneNumber(
                companyInfoBO.getTelephoneNumber());
        companyInfoVO.setMail(companyInfoBO.getMail());
        companyInfoVO.setWebUrl(companyInfoBO.getWebUrl());
        companyInfoVO.setStory(companyInfoBO.getStory());
        companyInfoVO.setVideoUrl(companyInfoBO.getVideoUrl());
        companyInfoVO.setLatitude(companyInfoBO.getLatitude());
        companyInfoVO.setLongitude(companyInfoBO.getLongitude());
        return companyInfoVO;
    }
}
