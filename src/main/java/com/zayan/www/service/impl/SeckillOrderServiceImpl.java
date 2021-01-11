package com.zayan.www.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zayan.www.model.entity.SeckillOrder;
import com.zayan.www.repository.SeckillOrderMapper;
import com.zayan.www.service.SeckillOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AnYuan
 * @since 2021-01-07
 */
@Service
public class SeckillOrderServiceImpl extends ServiceImpl<SeckillOrderMapper, SeckillOrder> implements SeckillOrderService {

    @Override
    public SeckillOrder getByTraceId(String traceId) {
        return getOne(new QueryWrapper<SeckillOrder>().lambda().eq(SeckillOrder::getTraceId, traceId));
    }

    @Override
    public SeckillOrder getByTraceIdAndUserId(String traceId, Integer userId) {
        return getOne(new QueryWrapper<SeckillOrder>().lambda().eq(SeckillOrder::getTraceId, traceId).eq(SeckillOrder::getUserId, userId));
    }
}
