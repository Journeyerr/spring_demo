package com.zayan.www.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zayan.www.model.entity.ProductImage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zayan.www.model.vo.api.product.ProductImageVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author AnYuan
 * @since 2020-08-17
 */
public interface ProductImageMapper extends BaseMapper<ProductImage> {

    IPage<ProductImageVO> list(IPage iPage, @Param("shopId") Integer shopId, @Param("status") Integer status);

}
