package com.aimeow.iteastyle.dao.impl;

import java.util.List;

import com.aimeow.iteastyle.dao.StaticDataDAO;
import com.aimeow.iteastyle.domain.StaticDataDO;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class StaticDataImpl implements StaticDataDAO {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public StaticDataDO getStaticData() throws Exception {
        Query query=new Query();
        StaticDataDO staticDataDO =  mongoTemplate
            .findOne(query , StaticDataDO.class);
        return staticDataDO;
    }

    @Override
    public Boolean replaceStaticData(
        @NonNull StaticDataDO staticDataDO
    ) throws Exception {

        if (StringUtils.isEmpty(staticDataDO.getContactUsTitle())) {
            throw new Exception("contactUsTitle can not be null");
        }
        if (StringUtils.isEmpty(staticDataDO.getLogoUrl())) {
            throw new Exception("logoUrl can not be null");
        }
        if (StringUtils.isEmpty(staticDataDO.getCompanyStoryBgUrl())) {
            throw new Exception("companyStoryBgUrl can not be null");
        }
        if (StringUtils.isEmpty(staticDataDO.getProductShowerHeaderUrl())) {
            throw new Exception("productShowerHeaderUrl can not be null");
        }
        if (StringUtils.isEmpty(staticDataDO.getPostBgUrl())) {
            throw new Exception("postBgUrl can not be null");
        }
        if (StringUtils.isEmpty(staticDataDO.getContactUsBgUrl())) {
            throw new Exception("contactUsBgUrl can not be null");
        }
        if (null == staticDataDO.getHomepageBannerUrls()) {
            throw new Exception("homepageBannerUrls can not be null");
        }
        if (null == staticDataDO.getHomepageServiceImageUrls()) {
            throw new Exception("homepageServiceImageUrls can not be null");
        }
        if (null == staticDataDO.getHomepageShowerImageUrls()) {
            throw new Exception("homepageShowerImageUrls can not be null");
        }



        List<StaticDataDO> lists = mongoTemplate
            .findAll(StaticDataDO.class);
        lists.iterator().forEachRemaining(
            obj-> {
                mongoTemplate.remove(obj);
            }
        );

        mongoTemplate.save(staticDataDO);
        return true;
    }
}
