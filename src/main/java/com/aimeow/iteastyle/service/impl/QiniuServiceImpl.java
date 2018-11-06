package com.aimeow.iteastyle.service.impl;

import com.aimeow.domain.BaseResult;
import com.aimeow.iteastyle.service.QiniuService;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Component;

/**
 * Created on 2018/11/6 11:52 AM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */
@Component
public class QiniuServiceImpl implements QiniuService {
    private static String accessKey = "7hKfN1Ymb8704XrZr09Hh1FpVLAHBzDFn7hxel30";
    private static String secretKey = "0w9SrQKJgZZk5zAjAKC1Ec3v2XCEtgv-FBmAPILc";
    private static String bucket = "iteastyle-test";

    @Override
    public BaseResult<String> getUploadToken() {
        BaseResult<String> result = new BaseResult<>();
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        result.setModel(upToken);
        return result;
    }
}
