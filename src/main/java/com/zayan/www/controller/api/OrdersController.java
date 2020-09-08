package com.zayan.www.controller.api;


import com.zayan.www.model.dto.user.BaseUser;
import com.zayan.www.model.entity.Order;
import com.zayan.www.model.entity.User;
import com.zayan.www.model.form.api.CreateOrderForm;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author AnYuan
 * @since 2020-09-08
 */
@RestController
@RequestMapping("/api/order")
public class OrdersController extends BaseController{

    @Autowired
    private OrderService orderService;

    @PostMapping("/store")
    public BaseResult<Order> storeOrder(@RequestBody CreateOrderForm orderForm) {
        User user = baseUser();
        Order order = orderService.storeOrder(orderForm, user.getId());
        return BaseResult.success(order);
    }
}

