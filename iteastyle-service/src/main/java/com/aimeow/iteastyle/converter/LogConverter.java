package com.aimeow.iteastyle.converter;

import com.aimeow.iteastyle.domain.LogBO;
import com.aimeow.iteastyle.domain.LogDO;
import com.aimeow.iteastyle.domain.LogVO;
import lombok.NonNull;

public class LogConverter {

    public static LogBO convertDTB(
            @NonNull LogDO logDO) {
        LogBO logBO = new LogBO();
        logBO.setContent(logDO.getContent());
        logBO.setOperator(logDO.getOperator());
        logBO.setId(logDO.getId());
        logBO.setGmtCreate(logDO.getGmtCreate());
        logBO.setGmtModified(logDO.getGmtModified());
        return logBO;
    }

    public static LogDO convertBTD(
            @NonNull LogBO logBO) {
        LogDO logDO = new LogDO();
        logDO.setContent(logBO.getContent());
        logDO.setOperator(logBO.getOperator());
        logDO.setId(logBO.getId());
        logDO.setGmtCreate(logBO.getGmtCreate());
        logDO.setGmtModified(logBO.getGmtModified());
        return logDO;
    }

    public static LogVO convertBTV(
            @NonNull LogBO logBO) {
        LogVO logVO = new LogVO();
        logVO.setContent(logBO.getContent());
        logVO.setOperator(logBO.getOperator());
        logVO.setId(logBO.getId());
        logVO.setGmtCreate(logBO.getGmtCreate());
        logVO.setGmtModified(logBO.getGmtModified());
        return logVO;
    }
}
