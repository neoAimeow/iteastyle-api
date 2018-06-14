package com.aimeow.iteastyle.manager;

import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.domain.StaticDataBO;

public interface StaticDataManager {
    Result<StaticDataBO> getStaticData() throws Exception;
    Result<Boolean> updateStaticData(
            StaticDataBO staticDataBO) throws Exception;
}
