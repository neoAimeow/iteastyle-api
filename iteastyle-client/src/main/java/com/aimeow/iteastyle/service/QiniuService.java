package com.aimeow.iteastyle.service;

import com.aimeow.iteastyle.domain.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/upload")
@RestController
public interface QiniuService {

    @RequestMapping(value = "/getUploadToken", method = RequestMethod.GET)
    Result<String> getUploadToken();
}
