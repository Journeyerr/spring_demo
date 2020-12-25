package com.zayan.www.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zayan.www.model.entity.Shop;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author AnYuan
 * @since 2020-08-17
 */
public interface ShopService extends IService<Shop> {

    List<Shop> shops();
}
