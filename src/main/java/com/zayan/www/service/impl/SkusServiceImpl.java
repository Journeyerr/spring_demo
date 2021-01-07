package com.zayan.www.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zayan.www.model.entity.Skus;
import com.zayan.www.repository.SkusMapper;
import com.zayan.www.service.SkusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author AnYuan
 * @since 2020-06-28
 */
@Service
public class SkusServiceImpl extends ServiceImpl<SkusMapper, Skus> implements SkusService {

    @Override
    public Skus getByNo(Integer no) {
        return getOne(new QueryWrapper<Skus>().lambda().eq(Skus::getNo, no));
    }
}
