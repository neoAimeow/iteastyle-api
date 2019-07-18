package com.aimeow.iteastyle.tools.tools;


import com.aimeow.iteastyle.tools.domain.BaseResult;

public class ResultUtil {
    public static <T> BaseResult<T> buildSuccessResult(BaseResult<T> result, T t) {
        result.setSuccess(true);
        result.setModel(t);
        result.setMsgInfo("");
        result.setMsgCode("");
        return result;
    }

    public static <T> BaseResult<T> setErrMsg(BaseResult<T> result, String errorMessage) {
        result.setSuccess(false);
        result.setMsgInfo(errorMessage);
        return result;
    }


    public static <T> BaseResult<T> setErrMsgAndCode(BaseResult<T> result, String errorMessage,String errorCode){
        setErrMsg(result, errorMessage);
        result.setMsgCode(errorCode);
        return result;
    }

    public static BaseResult getFailureResult(String errorMessage,String errorCode){
        BaseResult resultDO = new BaseResult();
        resultDO.setSuccess(false);
        resultDO.setMsgInfo(errorMessage);
        resultDO.setMsgCode(errorCode);
        return resultDO;
    }

    public static BaseResult getFailureResult(String errorMessage){
        return getFailureResult(errorMessage,null);
    }
}
