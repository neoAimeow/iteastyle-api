package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.domain.StaticDataVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface StaticDataService {
    @RequestMapping("/staticData/getData")
    Result<StaticDataVO> getStaticData();
}
