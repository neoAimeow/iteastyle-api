package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.domain.StaticDataVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface StaticDataService {
    @RequestMapping(value = "/staticData/getData", method = RequestMethod.GET, consumes="application/json")
    Result<StaticDataVO> getStaticData();
}
