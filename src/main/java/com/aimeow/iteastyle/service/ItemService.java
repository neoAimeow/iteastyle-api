package com.aimeow.iteastyle.service;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/item",tags = {"商品接口"}, description = "商品接口")
@RequestMapping(value = "/item")
@RestController
public interface ItemService {
}
