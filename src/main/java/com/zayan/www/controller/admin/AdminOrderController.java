package com.zayan.www.controller.admin;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Maps;
import com.zayan.www.constant.common.aliyun.ALiYunOss;
import com.zayan.www.constant.enums.OrderStatusEnum;
import com.zayan.www.model.form.admin.user.AdminEditPasswordForm;
import com.zayan.www.model.form.admin.user.AdminLoginForm;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.model.vo.order.OrderDetailVO;
import com.zayan.www.model.vo.user.AdminUserVO;
import com.zayan.www.repository.OrderMapper;
import com.zayan.www.service.AdminUserService;
import com.zayan.www.service.OrderService;
import com.zayan.www.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author AnYuan
 * @since 2020-08-17
 */

@RestController
@RequestMapping("/admin/order")
public class AdminOrderController {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public BaseResult<IPage<OrderDetailVO>> orderList(@PathVariable(value="shopId",required=false) Integer shopId,
                                       @PathVariable(value="status",required=false) String status,
                                       @RequestParam("page") Integer page,
                                       @RequestParam("pageSize") Integer pageSize) {

        return BaseResult.success(orderService.orderIPage(new Page(page, pageSize), shopId, status));
    }

    @GetMapping("/detail/{no}")
    public BaseResult<OrderDetailVO> orderList(@PathVariable String no) {
        OrderDetailVO orderDetailVO = orderMapper.getByNo(no);
        orderDetailVO.getItems().forEach(item->{
            item.setImage(ALiYunOss.BUCKET + item.getImage());
        });
        orderDetailVO.setStatusName(OrderStatusEnum.getMsgByCode(orderDetailVO.getStatus()));
        return BaseResult.success(orderDetailVO);
    }
}

