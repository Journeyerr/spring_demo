package com.zayan.www.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zayan.www.model.entity.Address;
import com.zayan.www.repository.AddressMapper;
import com.zayan.www.service.AddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
                .eq(Address::getDeletedAt, null));
    }
}
