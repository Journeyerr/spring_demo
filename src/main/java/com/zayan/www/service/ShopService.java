package com.zayan.www.service;

import com.zayan.www.model.entity.Shop;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 门店表 服务类
 * </p>
 *
 * @author AnYuan
 * @since 2019-05-25
 */
public interface ShopService extends IService<Shop> {

    /**
     * 获取所有门店
     * @return shops
     */
    List<Shop> shops();

}
