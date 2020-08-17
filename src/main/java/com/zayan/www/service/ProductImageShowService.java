package com.zayan.www.service;

import com.zayan.www.model.entity.ProductImageShow;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author AnYuan
 * @since 2020-08-17
 */
public interface ProductImageShowService extends IService<ProductImageShow> {

    /**
     * 保存图片路径 和 商品图片
     * @param imagePath imagePath
     * @param price price
     * @param remark remark
     * @return ProductImageShow
     */
    ProductImageShow saveImagesAndShow(String imagePath, BigDecimal price, String remark);
}
