package com.zayan.www.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zayan.www.model.entity.Banner;
import com.zayan.www.model.vo.admin.BannerVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author AnYuan
 * @since 2020-09-01
 */
public interface BannerMapper extends BaseMapper<Banner> {

    IPage<BannerVO> bannerList(@Param("shopId") Integer shopId, @Param("status") Integer status, IPage iPage);
}
