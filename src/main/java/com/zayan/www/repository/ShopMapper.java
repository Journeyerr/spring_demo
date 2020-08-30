package com.zayan.www.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zayan.www.model.entity.Shop;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author AnYuan
 * @since 2020-08-17
 */
public interface ShopMapper extends BaseMapper<Shop> {

    /**
     * 获取shop列表
     * @param page page
     * @return Shops
     */
    IPage<Shop> list(IPage page);
}
