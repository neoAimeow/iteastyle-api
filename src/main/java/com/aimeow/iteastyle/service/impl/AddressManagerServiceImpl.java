package com.aimeow.iteastyle.service.impl;

import java.util.List;

import com.aimeow.domain.BaseResult;
import com.aimeow.iteastyle.domain.entity.AddressEntity;
import com.aimeow.iteastyle.domain.query.AddressQuery;
import com.aimeow.iteastyle.domain.request.CreateAddressRequest;
import com.aimeow.iteastyle.domain.request.UpdateAddressRequest;
import com.aimeow.iteastyle.service.AddressManagerService;
import com.aimeow.tools.CommonDAO;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.jvm.hotspot.debugger.Address;

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
        BaseResult<Boolean> result = new BaseResult<Boolean>();
        try {
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setUserId(request.getUserId());
            addressEntity.setConsignee(request.getConsignee());
            addressEntity.setGender(request.getGender());
            addressEntity.setPhoneNo(request.getPhoneNo());
            addressEntity.setProvince(request.getProvince());
            addressEntity.setCity(request.getCity());
            addressEntity.setDistrict(request.getDistrict());
            addressEntity.setAddress(request.getAddress());
            addressEntity.setAddressDetail(request.getAddressDetail());
            addressEntity.setTag(request.getTag());
            addressEntity.setIsDefault(request.getIsDefault());
            addressEntity.setLatitude(request.getLatitude());
            addressEntity.setLongitude(request.getLongitude());

            if (request.getIsDefault()) {
                AddressEntity updateEntity = new AddressEntity();
                updateEntity.setIsDefault(false);

                commonDAO.update(updateEntity , AddressEntity.class);
            }
            result.setModel(commonDAO.create(addressEntity));

        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMsgInfo(ex.getMessage());
        }

        return result;
    }

    @Override
    public BaseResult<Boolean> updateAddress(UpdateAddressRequest request) {
        BaseResult<Boolean> result = new BaseResult<Boolean>();
        try {
            AddressEntity entity = commonDAO.queryById(request.getAddressId() , AddressEntity.class);
            if (entity == null) {
                result.setModel(false);
                result.setSuccess(false);
                result.setMsgInfo("查不到地址");
                return result;
            }

            if (!entity.getUserId().equals(request.getUserId())) {
                result.setModel(false);
                result.setSuccess(false);
                result.setMsgInfo("非该用户地址");
                return result;
            }

            entity.setUserId(request.getUserId());
            entity.setConsignee(request.getConsignee());
            entity.setGender(request.getGender());
            entity.setPhoneNo(request.getPhoneNo());
            entity.setProvince(request.getProvince());
            entity.setCity(request.getCity());
            entity.setDistrict(request.getDistrict());
            entity.setAddress(request.getAddress());
            entity.setAddressDetail(request.getAddressDetail());
            entity.setTag(request.getTag());
            entity.setIsDefault(request.getIsDefault());
            entity.setLatitude(request.getLatitude());
            entity.setLongitude(request.getLongitude());

            if (request.getIsDefault()) {
                AddressEntity updateEntity = new AddressEntity();
                updateEntity.setIsDefault(false);

                commonDAO.update(updateEntity , AddressEntity.class);
            }

            result.setModel(commonDAO.updateById(entity , AddressEntity.class));

        } catch (Exception ex) {
            result.setSuccess(false);
            result.setMsgInfo(ex.getMessage());
        }
        return result;
    }
}
