package com.zayan.www.service;

import com.zayan.www.model.entity.Address;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zayan.www.model.form.api.AddressCreateForm;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author AnYuan
 * @since 2020-09-04
 */
public interface AddressService extends IService<Address> {

    /**
     * 获取用户地址列表
     * @param userId userId
     * @return List<Address>
     */
    List<Address> addressList(Integer userId);

    /**
     * 创建用户地址
     * @param createForm createForm
     * @param userId userId
     * @return Address
     */
    Address saveAddress(AddressCreateForm createForm, Integer userId);
}
