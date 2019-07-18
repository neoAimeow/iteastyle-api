package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.ViewObject.Case.CasesInTypeVO;
import com.aimeow.iteastyle.domain.entity.CaseEntity;
import com.aimeow.iteastyle.domain.entity.PostEntity;
import com.aimeow.iteastyle.tools.domain.BaseGetList;
import com.aimeow.iteastyle.tools.domain.BaseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/service")
@RestController
public interface WebDataService {

    @RequestMapping(value = "/getPosts", method = RequestMethod.GET)
    BaseResult<BaseGetList> getPosts(Integer page, Integer pageSize);

    @RequestMapping(value = "/getPostById", method = RequestMethod.GET)
    BaseResult<PostEntity> getPostByPostId(String postId);

    @RequestMapping(value = "/getCaseById", method = RequestMethod.GET)
    BaseResult<CaseEntity> getCaseById(String caseId);

    @RequestMapping(value = "/getCaseByType", method = RequestMethod.GET)
    BaseResult<BaseGetList> getCaseByType(Integer type , Integer page , Integer pageSize);

    @RequestMapping(value = "/getCasesHomeData", method = RequestMethod.GET)
    BaseResult<List<CasesInTypeVO>> getCasesHomeData();

    @RequestMapping(value = "/getTeaDIYService", method = RequestMethod.GET)
    BaseResult<BaseGetList> getTeaDIYService(Integer page, Integer pageSize);

    @RequestMapping(value = "/getTeaPerformService", method = RequestMethod.GET)
    BaseResult<BaseGetList> getTeaPerformService(Integer page, Integer pageSize);

    @RequestMapping(value = "/getTeaLectureService", method = RequestMethod.GET)
    BaseResult<BaseGetList> getTeaLectureService(Integer page, Integer pageSize);
}
