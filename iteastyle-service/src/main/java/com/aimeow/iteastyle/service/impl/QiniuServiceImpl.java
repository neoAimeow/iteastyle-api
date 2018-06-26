package com.aimeow.iteastyle.service.impl;

import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.service.QiniuService;
import com.qiniu.util.Auth;

public class QiniuServiceImpl implements QiniuService {
    private static String accessKey = "你的AK";
    private static String secretKey = "你的SK";
    private static String bucket = "你的存储空间名";

    @Override
    public Result<String> getUploadToken() {
        Result<String> result = new Result<>();
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        result.setModel(upToken);
        return result;
    }
}
