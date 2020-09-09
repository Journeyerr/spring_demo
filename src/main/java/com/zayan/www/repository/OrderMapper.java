package com.zayan.www.repository;

import com.zayan.www.model.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zayan.www.model.vo.order.OrderDetailVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author AnYuan
 * @since 2020-09-08
 */
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 根据userId 查询所有订单
     * @param userId userId
     * @return List<OrderDetailVO>
     */
    List<OrderDetailVO> listByUserId(@Param("userId") Integer userId);
}
