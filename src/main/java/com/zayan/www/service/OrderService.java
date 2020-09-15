package com.zayan.www.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zayan.www.model.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zayan.www.model.form.api.CreateOrderForm;
import com.zayan.www.model.vo.order.OrderDetailVO;
import org.apache.ibatis.annotations.Param;

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


    /**
     * 分页查询订单
     * @param iPage 分页
     * @param shopId shopId
     * @param status 订单状态
     * @return ipage
     */
    IPage<OrderDetailVO> orderIPage(IPage iPage, Integer shopId, String status);
}
