package com.aimeow.iteastyle.service.impl;

import com.aimeow.iteastyle.converter.StaticDataConverter;
import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.domain.StaticDataVO;
import com.aimeow.iteastyle.manager.StaticDataManager;
import com.aimeow.iteastyle.service.StaticDataService;
import org.springframework.beans.factory.annotation.Autowired;

public class StaticDataServiceImpl
        implements StaticDataService {
    @Autowired private StaticDataManager staticDataManager;
    @Override
    public Result<StaticDataVO> getStaticData() {
        Result<StaticDataVO> result = new Result<>();
        try {
            result.setModel(StaticDataConverter.convertBTV(
                    staticDataManager.getStaticData().getModel()));
        } catch (Exception e) {
            result.setSuccess(false);
            return result;
        }
        return result;
    }
}
