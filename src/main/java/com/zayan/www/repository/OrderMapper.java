package com.zayan.www.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zayan.www.model.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zayan.www.model.vo.order.OrderDetailVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author AnYuan
 * @since 2020-09-08
 */

@Repository
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 根据userId 查询所有订单
     *
     * @param userId userId
     * @return List<OrderDetailVO>
     */
    List<OrderDetailVO> listByUserId(@Param("userId") Integer userId);

    /**
     * 根据shopId status查询所有订单
     *
     * @param shopId shopId
     * @param status status
     * @return List<OrderDetailVO>
     */
    IPage<OrderDetailVO> listRecord(IPage iPage,
                                    @Param("shopId") Integer shopId,
                                    @Param("status") String status,
                                    @Param("no") String no);


    OrderDetailVO getByNo(@Param("no") String no);

}
