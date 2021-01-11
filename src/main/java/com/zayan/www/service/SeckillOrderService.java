package com.zayan.www.service;

import com.zayan.www.model.entity.SeckillOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author AnYuan
 * @since 2021-01-07
 */
public interface SeckillOrderService extends IService<SeckillOrder> {

    /**
     * 根据traceId查询order
     * @param traceId traceId
     * @return SeckillOrder
     */
    SeckillOrder getByTraceId(String traceId);

    /**
     * 根据traceId AND UserId 查询order
     * @param traceId traceId
     * @return SeckillOrder
     */
    SeckillOrder getByTraceIdAndUserId(String traceId, Integer userId);
}
