package com.aimeow.iteastyle.service.impl;

import com.aimeow.iteastyle.manager.CompanyInfoManager;
import com.aimeow.iteastyle.manager.PostManager;
import com.aimeow.iteastyle.manager.StaticDataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceImpl {
    @Autowired private CompanyInfoManager companyInfoManager;
    @Autowired private StaticDataManager staticDataManager;
    @Autowired private PostManager postManager;

}
