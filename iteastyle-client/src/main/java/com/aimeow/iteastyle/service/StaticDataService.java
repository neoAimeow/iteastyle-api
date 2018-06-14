package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.domain.StaticDataVO;

public interface StaticDataService {
    Result<StaticDataVO> getStaticData();
}
