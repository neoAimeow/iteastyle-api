package com.aimeow.iteastyle.converter;

import com.aimeow.iteastyle.domain.StaticData.StaticDataVO;
import com.aimeow.iteastyle.domain.StaticDataBO;
import com.aimeow.iteastyle.domain.StaticDataDO;
import lombok.NonNull;

public class StaticDataConverter {
    public static StaticDataBO convertDTB(
            @NonNull StaticDataDO staticDataDO) {
        StaticDataBO staticDataBO = new StaticDataBO();
        staticDataBO.setLogoUrl(staticDataDO.getLogoUrl());
        staticDataBO.setContactUsTitle(staticDataDO.getContactUsTitle());
        staticDataBO.setCompanyStoryBgUrl(staticDataDO.getCompanyStoryBgUrl());
        staticDataBO.setProductShowerHeaderUrl(staticDataDO.getProductShowerHeaderUrl());
        staticDataBO.setPostBgUrl(staticDataDO.getPostBgUrl());
        staticDataBO.setContactUsBgUrl(staticDataDO.getContactUsBgUrl());
        staticDataBO.setHomepageBannerUrls(staticDataDO.getHomepageBannerUrls());
        staticDataBO.setHomepageServiceImageUrls(staticDataDO.getHomepageServiceImageUrls());
        staticDataBO.setHomepageServiceWapImageUrls(staticDataDO.getHomepageServiceWapImageUrls());
        staticDataBO.setHomepageShowerImageUrls(staticDataDO.getHomepageShowerImageUrls());
        return staticDataBO;
    }

    public static StaticDataDO convertBTD(
            @NonNull StaticDataBO staticDataBO) {

        StaticDataDO staticDataDO = new StaticDataDO();
        staticDataDO.setContactUsTitle(staticDataBO.getContactUsTitle());
        staticDataDO.setLogoUrl(staticDataBO.getLogoUrl());
        staticDataDO.setCompanyStoryBgUrl(staticDataBO.getCompanyStoryBgUrl());
        staticDataDO.setProductShowerHeaderUrl(staticDataBO.getProductShowerHeaderUrl());
        staticDataDO.setPostBgUrl(staticDataBO.getPostBgUrl());
        staticDataDO.setContactUsBgUrl(staticDataBO.getContactUsBgUrl());
        staticDataDO.setHomepageBannerUrls(staticDataBO.getHomepageBannerUrls());
        staticDataDO.setHomepageServiceImageUrls(staticDataBO.getHomepageServiceImageUrls());
        staticDataDO.setHomepageShowerImageUrls(staticDataBO.getHomepageShowerImageUrls());
        staticDataDO.setHomepageServiceWapImageUrls(staticDataBO.getHomepageServiceWapImageUrls());

        return staticDataDO;
    }

    public static StaticDataVO convertBTV(
            @NonNull StaticDataBO staticDataBO) {

        StaticDataVO staticDataVO = new StaticDataVO();
        staticDataVO.setContactUsTitle(staticDataBO.getContactUsTitle());
        staticDataVO.setLogoUrl(staticDataBO.getLogoUrl());
        staticDataVO.setCompanyStoryBgUrl(staticDataBO.getCompanyStoryBgUrl());
        staticDataVO.setProductShowerHeaderUrl(staticDataBO.getProductShowerHeaderUrl());
        staticDataVO.setPostBgUrl(staticDataBO.getPostBgUrl());
        staticDataVO.setContactUsBgUrl(staticDataBO.getContactUsBgUrl());
        staticDataVO.setHomepageBannerUrls(staticDataBO.getHomepageBannerUrls());
        staticDataVO.setHomepageServiceImageUrls(staticDataBO.getHomepageServiceImageUrls());
        staticDataVO.setHomepageShowerImageUrls(staticDataBO.getHomepageShowerImageUrls());

        return staticDataVO;
    }

}
