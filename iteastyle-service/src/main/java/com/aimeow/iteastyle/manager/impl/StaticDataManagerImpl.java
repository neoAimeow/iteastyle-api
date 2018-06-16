package com.aimeow.iteastyle.manager.impl;

import com.aimeow.iteastyle.converter.StaticDataConverter;
import com.aimeow.iteastyle.dao.StaticDataDAO;
import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.domain.StaticDataBO;
import com.aimeow.iteastyle.manager.StaticDataManager;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StaticDataManagerImpl
        implements StaticDataManager {
    @Autowired private StaticDataDAO staticDataDAO;

    @Override
    public Result<StaticDataBO> getStaticData() throws Exception {
        Result<StaticDataBO> result = new Result<>();
        result.setModel(StaticDataConverter.convertDTB(
                staticDataDAO.getStaticData()));
        return result;
    }

    @Override
    public Result<Boolean> updateStaticData(
            @NonNull StaticDataBO staticDataBO) throws Exception  {
        Result<Boolean> result = new Result<>();

        result.setModel(staticDataDAO.replaceStaticData(
                StaticDataConverter.convertBTD(staticDataBO)));
        return result;
    }
}
