package com.zayan.www.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zayan.www.model.entity.Banner;
import com.zayan.www.model.vo.admin.BannerVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author AnYuan
 * @since 2020-09-01
 */
public interface BannerService extends IService<Banner> {

    IPage<BannerVO> listRecord(Integer shopId, Integer status, Integer page, Integer pageSize);
}
