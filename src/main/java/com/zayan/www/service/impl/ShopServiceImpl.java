package com.zayan.www.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zayan.www.model.entity.Shop;
import com.zayan.www.repository.ShopMapper;
import com.zayan.www.service.ShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author AnYuan
 * @since 2020-08-17
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements ShopService {

    @Override
    public List<Shop> shops() {
        return this.list(new QueryWrapper<Shop>().lambda().isNull(Shop::getDeletedAt));
    }
}
