package com.zayan.www.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zayan.www.constant.enums.ErrorEnum;
import com.zayan.www.exception.BaseException;
import com.zayan.www.model.entity.Address;
import com.zayan.www.model.form.api.AddressCreateForm;
import com.zayan.www.repository.AddressMapper;
import com.zayan.www.service.AddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zayan.www.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AnYuan
 * @since 2020-09-04
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

    @Override
    public List<Address> addressList(Integer userId) {
        return list(new QueryWrapper<Address>().lambda()
                .eq(Address::getUserId, userId)
                .isNull(Address::getDeletedAt));
    }

    @Override
    public Address saveAddress(AddressCreateForm createForm, Integer userId) {

        if (!StringUtil.isMobile(createForm.getPhone())) {
            throw new BaseException(ErrorEnum.PHONE_ERROR);
        }
        System.out.println(createForm.getAddress().length());
        System.out.println(createForm.getAddress());
        if (StringUtils.isBlank(createForm.getAddress()) || createForm.getAddress().length() < 6) {
            throw new BaseException(ErrorEnum.ADDRESS_ERROR);
        }

        Address address = new Address();
        address.setUserId(userId);
        address.setName(createForm.getName());
        address.setPhone(createForm.getPhone());
        address.setAddress(createForm.getAddress());
        save(address);

        return address;
    }
}
