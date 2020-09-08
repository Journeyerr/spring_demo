package com.zayan.www.service.impl;

import com.zayan.www.model.entity.Orders;
import com.zayan.www.repository.OrdersMapper;
import com.zayan.www.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author AnYuan
 * @since 2020-09-08
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

}
