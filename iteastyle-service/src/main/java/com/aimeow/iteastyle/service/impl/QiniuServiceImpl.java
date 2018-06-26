package com.aimeow.iteastyle.service.impl;

import com.aimeow.iteastyle.domain.Result;
import com.aimeow.iteastyle.service.QiniuService;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Component;

@Component
public class QiniuServiceImpl implements QiniuService {
    private static String accessKey = "7hKfN1Ymb8704XrZr09Hh1FpVLAHBzDFn7hxel30";
    private static String secretKey = "0w9SrQKJgZZk5zAjAKC1Ec3v2XCEtgv-FBmAPILc";
    private static String bucket = "iteastyle";

    @Override
    public Result<String> getUploadToken() {
        Result<String> result = new Result<>();
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        result.setModel(upToken);
        return result;
    }
}
