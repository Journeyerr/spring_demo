package com.zayan.www.service;

import com.zayan.www.model.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zayan.www.model.form.api.CreateOrderForm;

import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author AnYuan
 * @since 2020-09-08
 */
public interface OrderService extends IService<Order> {

    /**
     * 下单
     * @param createOrderForm createOrderForm
     * @param userId userId
     * @return Order
     */
    Order storeOrder(CreateOrderForm createOrderForm, Integer userId);


}
