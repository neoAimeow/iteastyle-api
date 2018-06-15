package com.aimeow.iteastyle.converter;

import com.aimeow.iteastyle.domain.StaticDataBO;
import com.aimeow.iteastyle.domain.StaticDataDO;
import com.aimeow.iteastyle.domain.StaticDataVO;
import lombok.NonNull;

public class StaticDataConverter {
    public static StaticDataBO convertDTB(
            @NonNull StaticDataDO staticDataDO) {
        StaticDataBO staticDataBO = new StaticDataBO();
        return staticDataBO;
    }

    public static StaticDataDO convertBTD(
            @NonNull StaticDataBO postBO) {
        StaticDataDO staticDataDO = new StaticDataDO();
        return staticDataDO;
    }

    public static StaticDataVO convertBTV(
            @NonNull StaticDataBO postBO) {
        StaticDataVO staticDataVO = new StaticDataVO();
        return staticDataVO;
    }
}
