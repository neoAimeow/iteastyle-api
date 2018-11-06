package com.aimeow.iteastyle.service.impl;

import java.util.List;

import com.aimeow.domain.BaseGetList;
import com.aimeow.domain.BaseResult;
import com.aimeow.iteastyle.domain.entity.AddressEntity;
import com.aimeow.iteastyle.domain.entity.PostEntity;
import com.aimeow.iteastyle.domain.enums.StatusEnum;
import com.aimeow.iteastyle.domain.query.AddressQuery;
import com.aimeow.iteastyle.domain.query.PostQuery;
import com.aimeow.iteastyle.domain.request.CreateAddressRequest;
import com.aimeow.iteastyle.domain.request.UpdateAddressRequest;
import com.aimeow.iteastyle.service.AddressManagerService;
import com.aimeow.tools.CommonDAO;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created on 2018/11/6 11:52 AM
 *
 * @author zhaoyi.w <zhaoyi.w@alibaba-inc.com>
 */
@Component
public class AddressManagerServiceImpl implements AddressManagerService {

    @Autowired private CommonDAO commonDAO;

    @Override
    public BaseResult<AddressEntity> getAddressByAdressId(String addressId) {
        BaseResult<AddressEntity> result = new BaseResult<>();
        try {
            result.setModel(commonDAO.queryById(addressId , AddressEntity.class));
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
    }

    @Override
    public BaseResult<List<AddressEntity>> getAddressByUserId(@NonNull String userId) {
        BaseResult<List<AddressEntity>> result = new BaseResult<List<AddressEntity>>();

        try {
            AddressQuery addressQuery= new AddressQuery();
            addressQuery.setUserId(userId);

            List<AddressEntity> addressEntities = commonDAO.queryList(
                addressQuery , AddressEntity.class, null , null
            );

        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsgInfo(e.getMessage());
        }
        return result;
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
