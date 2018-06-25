package com.aimeow.iteastyle.service.impl;

import com.aimeow.iteastyle.converter.CaseConverter;
import com.aimeow.iteastyle.converter.CaseTypeConverter;
import com.aimeow.iteastyle.converter.PostConverter;
import com.aimeow.iteastyle.converter.ProductShowerConverter;
import com.aimeow.iteastyle.domain.*;
import com.aimeow.iteastyle.domain.Case.CaseTypeVO;
import com.aimeow.iteastyle.domain.Case.CaseVO;
import com.aimeow.iteastyle.domain.Case.GetCasesVO;
import com.aimeow.iteastyle.domain.Post.GetPostsVO;
import com.aimeow.iteastyle.domain.Post.PostVO;
import com.aimeow.iteastyle.domain.ProductShower.GetProductShowersVO;
import com.aimeow.iteastyle.domain.ProductShower.ProductShowerVO;
import com.aimeow.iteastyle.domain.Web.CompanyStoryVO;
import com.aimeow.iteastyle.domain.Web.ContactUsVO;
import com.aimeow.iteastyle.domain.Web.HomePageVO;
import com.aimeow.iteastyle.domain.enums.StatusEnum;
import com.aimeow.iteastyle.manager.*;
import com.aimeow.iteastyle.service.WebDataService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WebDataServiceImpl implements WebDataService {
    @Autowired private StaticDataManager staticDataManager;
    @Autowired private CompanyInfoManager companyInfoManager;
    @Autowired private ProductShowerManager productShowerManager;
    @Autowired private PostManager postManager;
    @Autowired private CaseTypeManager caseTypeManager;
    @Autowired private CaseManager caseManager;

    @Override
    public Result<HomePageVO> getHomePageData() {
        Result<HomePageVO> result = new Result<>();
        try {
            StaticDataBO staticDataBO = staticDataManager.getStaticData().getModel();
            HomePageVO homePageVO = new HomePageVO();
            result.setModel(homePageVO);
            homePageVO.setHeaderImages(staticDataBO.getHomepageBannerUrls());
            homePageVO.setShowerImages(staticDataBO.getHomepageShowerImageUrls());
            homePageVO.setServiceImages(staticDataBO.getHomepageServiceImageUrls());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }

        return result;
    }

    @Override
    public Result<CompanyStoryVO> getCompanyStory() {
        Result<CompanyStoryVO> result = new Result<>();
        CompanyStoryVO companyStoryVO = new CompanyStoryVO();
        result.setModel(companyStoryVO);
        try {
            CompanyInfoBO companyInfoBO = companyInfoManager.getCompanyInfo().getModel();
            StaticDataBO staticDataBO = staticDataManager.getStaticData().getModel();

            companyStoryVO.setBackgroundImageUrl(staticDataBO.getCompanyStoryBgUrl());
            companyStoryVO.setVideoUrl(companyInfoBO.getVideoUrl());
            companyStoryVO.setStoryTitle(companyInfoBO.getStoryTitle());
            companyStoryVO.setStoryContent(companyInfoBO.getStory());

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public Result<ContactUsVO> getContactUsData() {
        Result<ContactUsVO> result = new Result<>();
        ContactUsVO contactUsVO = new ContactUsVO();
        result.setModel(contactUsVO);
        try {
            CompanyInfoBO companyInfoBO = companyInfoManager.getCompanyInfo().getModel();
            StaticDataBO staticDataBO = staticDataManager.getStaticData().getModel();
            contactUsVO.setCompanyAddress(companyInfoBO.getCompanyAddress());
            contactUsVO.setCompanyName(companyInfoBO.getCompanyName());
            contactUsVO.setContactUsBackgroundImage(staticDataBO.getContactUsBgUrl());
            contactUsVO.setLatitude(companyInfoBO.getLatitude());
            contactUsVO.setLongitude(companyInfoBO.getLongitude());
            contactUsVO.setMailAddress(companyInfoBO.getMail());
            contactUsVO.setPhoneNumber(companyInfoBO.getPhoneNumber());
            contactUsVO.setTelephoneNumber(companyInfoBO.getTelephoneNumber());
            contactUsVO.setSiteAddress(companyInfoBO.getWebUrl());
            contactUsVO.setContactUsTitle(staticDataBO.getContactUsTitle());

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }


        return result;
    }

    @Override
    public Result<GetProductShowersVO> getProductShowerList(
            Integer page, Integer pageSize) {
        Result<GetProductShowersVO> result = new Result<>();
        GetProductShowersVO getProductShowersVO = new GetProductShowersVO();
        result.setModel(getProductShowersVO);
        List<ProductShowerVO> productShowerVOS = new ArrayList<>();
        try {
            StaticDataBO staticDataBO = staticDataManager.getStaticData().getModel();
            getProductShowersVO.setHeaderImageUrl(staticDataBO.getProductShowerHeaderUrl());
            getProductShowersVO.setPage(page);
            getProductShowersVO.setPageSize(pageSize);
            getProductShowersVO.setTotalCount(
                    productShowerManager.countProductShower(StatusEnum.NORMAL.getStatus()).getModel()
            );
            List<ProductShowerBO> productShowerBOS = productShowerManager.getProductShowerList(
                    StatusEnum.NORMAL.getStatus(), page , pageSize
            ).getModel();

            productShowerBOS.iterator().forEachRemaining(
                    obj-> {
                        productShowerVOS.add(ProductShowerConverter.convertBTV(obj));
                    }
            );
            getProductShowersVO.setProducts(productShowerVOS);


        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public Result<ProductShowerVO> getProductShowerDetail(@NonNull String productShowerId) {
        Result<ProductShowerVO> result = new Result<>();

        try {
            ProductShowerBO productShowerBO = productShowerManager
                    .getProductShowerById(productShowerId).getModel();
            result.setModel(ProductShowerConverter.convertBTV(productShowerBO));
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }


    @Override
    public Result<GetPostsVO> getPosts(
            Integer page, Integer pageSize) {
        Result<GetPostsVO> result = new Result<GetPostsVO>();
        GetPostsVO getPostsVO = new GetPostsVO();
        try {
            StaticDataBO staticDataBO = staticDataManager.getStaticData().getModel();
            getPostsVO.setPostBackgroundImage(staticDataBO.getPostBgUrl());
            getPostsVO.setPage(page);
            getPostsVO.setPageSize(pageSize);
            List<PostVO> postVos = new ArrayList();
            List<PostBO> postBos = postManager.getPosts(
                    0 , page , pageSize).getModel();
            postBos.iterator().forEachRemaining(
                    obj-> {
                        postVos.add(PostConverter.convertBTV(obj));
                    }
            );
            getPostsVO.setTotalCount(postManager.countPosts(0).getModel());

            getPostsVO.setPosts(postVos);
            result.setModel(getPostsVO);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public Result<PostVO> getPostByPostId(
            @NonNull String postId) {
        Result<PostVO> result = new Result<>();
        try {
            result.setModel(PostConverter.convertBTV(
                    postManager.getPostById(postId).getModel()));
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public Result<List<CaseTypeVO>> getCaseTypes() {
        Result<List<CaseTypeVO>> result = new Result<>();
        try {
            List<CaseTypeVO> caseTypeVOS = new ArrayList<>();

            List<CaseTypeBO> caseTypeBOS = caseTypeManager.getCaseTypes().getModel();
            caseTypeBOS.iterator().forEachRemaining(
                    obj-> {
                        caseTypeVOS.add(CaseTypeConverter.convertBTV(obj));
                    }
            );
            result.setModel(caseTypeVOS);

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public Result<CaseVO> getCaseById(
            @NonNull String caseId) {
        Result<CaseVO> result = new Result<>();

        try {
            CaseBO caseBO = caseManager.getCaseById(caseId).getModel();
            CaseVO caseVO = CaseConverter.convertBTV(caseBO);
            caseVO.setTypeName(caseTypeManager.getCaseTypeByTypeCode(caseBO.getType()).getModel().getTypeName());
            result.setModel(CaseConverter.convertBTV(caseBO));
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public Result<GetCasesVO> getCases(
            @NonNull Integer type , Integer page, Integer pageSize) {
        Result<GetCasesVO> result = new Result<>();
        GetCasesVO getCasesVO = new GetCasesVO();
        try {
            getCasesVO.setPage(page);
            getCasesVO.setPageSize(pageSize);
            getCasesVO.setTotalCount(caseManager.countCases(type).getModel());
            List<CaseVO> caseVOS = new ArrayList<>();

            List<CaseBO> caseBOS = caseManager.getCases(type , page , pageSize).getModel();
            caseBOS.iterator().forEachRemaining(
                    obj-> {
                        caseVOS.add(CaseConverter.convertBTV(obj));
                    }
            );
            getCasesVO.setCases(caseVOS);
            result.setModel(getCasesVO);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }
}
