package com.aimeow.iteastyle.dao.impl;

import java.util.List;

import com.aimeow.iteastyle.dao.CompanyInfoDAO;
import com.aimeow.iteastyle.domain.CompanyInfoDO;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CompanyInfoDAOImpl implements CompanyInfoDAO {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public CompanyInfoDO getCompanyInfo() throws Exception {
        Query query=new Query();
        CompanyInfoDO companyInfoDO =  mongoTemplate.findOne(query , CompanyInfoDO.class);
        return companyInfoDO;
    }

    @Override
    public Boolean replaceCompanyInfoData(
        @NonNull CompanyInfoDO companyInfoDO) throws Exception {

        if (StringUtils.isEmpty(companyInfoDO.getCompanyName())) {
            throw new Exception("CompanyName can not be null");
        }
        if (StringUtils.isEmpty(companyInfoDO.getCompanyAddress())) {
            throw new Exception("companyAddress can not be null");
        }
        if (StringUtils.isEmpty(companyInfoDO.getPostCode())) {
            throw new Exception("postCode can not be null");
        }
        if (StringUtils.isEmpty(companyInfoDO.getPhoneNumber())) {
            throw new Exception("phoneNumber can not be null");
        }
        if (StringUtils.isEmpty(companyInfoDO.getTelephoneNumber())) {
            throw new Exception("telephoneNumber can not be null");
        }
        if (StringUtils.isEmpty(companyInfoDO.getMail())) {
            throw new Exception("mail can not be null");
        }
        if (StringUtils.isEmpty(companyInfoDO.getWebUrl())) {
            throw new Exception("webUrl can not be null");
        }
        if (StringUtils.isEmpty(companyInfoDO.getStoryTitle())) {
            throw new Exception("storyTitle can not be null");
        }
        if (StringUtils.isEmpty(companyInfoDO.getStory())) {
            throw new Exception("story can not be null");
        }
        if (StringUtils.isEmpty(companyInfoDO.getVideoUrl())) {
            throw new Exception("videoUrl can not be null");
        }
        if (StringUtils.isEmpty(companyInfoDO.getLatitude())) {
            throw new Exception("latitude can not be null");
        }
        if (StringUtils.isEmpty(companyInfoDO.getLongitude())) {
            throw new Exception("longitude can not be null");
        }

        List<CompanyInfoDO> lists = mongoTemplate.findAll(CompanyInfoDO.class);
        lists.iterator().forEachRemaining(
            obj-> {
                mongoTemplate.remove(obj);
            }
        );

        mongoTemplate.save(companyInfoDO);
        return true;
    }
}
