package com.zayan.www.service.impl;

import com.zayan.www.model.entity.OrderAddress;
import com.zayan.www.repository.OrderAddressMapper;
import com.zayan.www.service.OrderAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单地址 服务实现类
 * </p>
 *
 * @author AnYuan
 * @since 2020-09-08
 */
@Service
public class OrderAddressServiceImpl extends ServiceImpl<OrderAddressMapper, OrderAddress> implements OrderAddressService {

}
