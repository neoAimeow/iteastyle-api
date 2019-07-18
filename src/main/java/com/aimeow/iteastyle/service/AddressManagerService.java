package com.aimeow.iteastyle.service;

import java.util.List;

import com.aimeow.iteastyle.domain.entity.AddressEntity;
import com.aimeow.iteastyle.domain.request.CreateAddressRequest;
import com.aimeow.iteastyle.domain.request.UpdateAddressRequest;
import com.aimeow.iteastyle.tools.domain.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2018/11/6 11:46 AM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */
@Api(value = "/address",tags = {"通用接口"}, description = "通用的接口数据")
@RequestMapping(value = "/address")
@RestController
public interface AddressManagerService {
    @ApiOperation(value = "通过GET请求方式通过userId获取该用户地址")
    @RequestMapping(value = "/getAddressByAddressId", method = RequestMethod.GET)
    BaseResult<AddressEntity> getAddressByAdressId(String addressId);

    @ApiOperation(value = "通过GET请求方式通过userId获取该用户地址列表")
    @RequestMapping(value = "/getAddressByUserId", method = RequestMethod.GET)
    BaseResult<List<AddressEntity>> getAddressByUserId(String userId);

    @ApiOperation(value = "通过POST请求方式创建用户收货地址")
    @RequestMapping(value = "/createAddress", method = RequestMethod.POST)
    BaseResult<Boolean> createAddress(CreateAddressRequest request);

    @ApiOperation(value = "通过POST请求方式修改用户收货地址")
    @RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
    BaseResult<Boolean> updateAddress(UpdateAddressRequest request);

    @ApiOperation(value = "通过GET请求方式通过userId获取该用户默认收货地址")
    @RequestMapping(value = "/getDefaultAddressByUserId", method = RequestMethod.GET)
    BaseResult<AddressEntity> getDefaultAddress(String userId);
}
