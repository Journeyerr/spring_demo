package com.zayan.www.service.impl;

import com.zayan.www.model.entity.OrderItems;
import com.zayan.www.repository.OrderItemsMapper;
import com.zayan.www.service.OrderItemsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单详情项 服务实现类
 * </p>
 *
 * @author AnYuan
 * @since 2020-09-08
 */
@Service
public class OrderItemsServiceImpl extends ServiceImpl<OrderItemsMapper, OrderItems> implements OrderItemsService {

}
