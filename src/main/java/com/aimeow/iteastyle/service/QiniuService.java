package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.tools.domain.BaseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/upload")
@RestController
public interface QiniuService {
    @RequestMapping(value = "/getUploadToken", method = RequestMethod.GET)
    BaseResult<String> getUploadToken();
}
