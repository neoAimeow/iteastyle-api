package com.aimeow.iteastyle;

import com.aimeow.iteastyle.dao.CompanyInfoDAO;
import com.aimeow.iteastyle.domain.CompanyInfoDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class CompanyInfoTests {

    @Autowired private CompanyInfoDAO companyInfoDAO;

    @Autowired private MockMvc mockMvc;

    @Test public void testGetCompanyInfo() throws Exception {
        System.out.println(companyInfoDAO.getCompanyInfo());
    }

    @Test public void testReplaceCompanyInfo() throws Exception {
        CompanyInfoDO companyInfoDO = new CompanyInfoDO();

        companyInfoDO.setCompanyInfo("companyInfo");
        companyInfoDO.setPostCode("postCode");
        companyInfoDO.setPhoneNumber("phoneNumber");
        companyInfoDO.setTelephoneNumber("telephoneNumber");
        companyInfoDO.setMail("mail");
        companyInfoDO.setWebUrl("weburl");
        companyInfoDO.setStory("story");
        companyInfoDO.setVideoUrl("videoUrl");

        companyInfoDAO.replaceCompanyInfoData(companyInfoDO);
    }
}
