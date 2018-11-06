package com.aimeow.iteastyle.service.impl;

import java.util.List;

import com.aimeow.domain.BaseResult;
import com.aimeow.iteastyle.domain.entity.AddressEntity;
import com.aimeow.iteastyle.domain.request.CreateAddressRequest;
import com.aimeow.iteastyle.domain.request.UpdateAddressRequest;
import com.aimeow.iteastyle.service.AddressManagerService;

/**
 * Created on 2018/11/6 11:52 AM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */
public class AddressManagerServiceImpl implements AddressManagerService {
    @Override
    public BaseResult<AddressEntity> getAddressByAdressId(String userId, String addressId) {
        return null;
    }

    @Override
    public BaseResult<List<AddressEntity>> getAddressByUserId(String userId) {
        return null;
    }

    @Override
    public BaseResult<Boolean> createAddress(CreateAddressRequest request) {
        return null;
    }

    @Override
    public BaseResult<Boolean> updateAddress(UpdateAddressRequest request) {
        return null;
    }
}
