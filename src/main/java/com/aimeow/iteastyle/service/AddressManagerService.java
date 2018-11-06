package com.aimeow.iteastyle.service;

import java.util.List;

import com.aimeow.domain.BaseResult;
import com.aimeow.iteastyle.domain.entity.AddressEntity;
import com.aimeow.iteastyle.domain.request.CreateAddressRequest;
import com.aimeow.iteastyle.domain.request.UpdateAddressRequest;

/**
 * Created on 2018/11/6 11:46 AM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */
public interface AddressManagerService {
    BaseResult<AddressEntity> getAddressByAdressId(String addressId);
    BaseResult<List<AddressEntity>> getAddressByUserId(String userId);
    BaseResult<Boolean> createAddress(CreateAddressRequest request);
    BaseResult<Boolean> updateAddress(UpdateAddressRequest request);
}
