package com.aimeow.iteastyle.service;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/order",tags = {"订单接口"}, description = "订单接口")
@RequestMapping(value = "/order")
@RestController
public interface OrderService {
}
