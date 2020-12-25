package com.zayan.www.controller.api;


import com.zayan.www.constant.common.aliyun.ALiYunOss;
import com.zayan.www.model.entity.Order;
import com.zayan.www.model.entity.User;
import com.zayan.www.model.form.api.CreateOrderForm;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.model.vo.order.OrderDetailVO;
import com.zayan.www.repository.OrderMapper;
import com.zayan.www.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.Objects;

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
public class OrdersController extends BaseController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderMapper orderMapper;

    @PostMapping("/store")
    public BaseResult<Order> storeOrder(@RequestBody CreateOrderForm orderForm) {
        User user = baseUser();
        Order order = orderService.storeOrder(orderForm, user.getId());
        return BaseResult.success(order);
    }

    @GetMapping("/list")
    public BaseResult<List<OrderDetailVO>> list() {
        User user = baseUser();
        List<OrderDetailVO> orderDetailVOS = orderMapper.listByUserId(user.getId());
        orderDetailVOS.forEach(order -> {
            order.getItems().forEach(item -> {
                if (Objects.nonNull(item.getImage())) {
                    item.setImage(ALiYunOss.BUCKET.concat(item.getImage()));
                }
            });
        });
        return BaseResult.success(orderDetailVOS);
    }
}

