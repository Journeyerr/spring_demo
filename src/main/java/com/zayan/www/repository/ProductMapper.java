package com.zayan.www.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zayan.www.model.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zayan.www.model.vo.product.ProductVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author AnYuan
 * @since 2020-08-17
 */
public interface ProductMapper extends BaseMapper<Product> {

    IPage<ProductVO> productsList(@Param("shopId") Integer shopId, @Param("status") Integer status, IPage iPage);

    ProductVO detail(@Param("productId") Integer productId);
}
