package com.zayan.www.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zayan.www.model.entity.ProductImage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zayan.www.model.vo.ProductImageVO;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author AnYuan
 * @since 2020-08-17
 */
public interface ProductImageService extends IService<ProductImage> {

    /**
     * 保存图片路径 和 商品图片
     * @param imagePath imagePath
     * @param shopId shopId
     * @param price price
     * @param remark remark
     * @return ProductImageShow
     */
    ProductImage saveImagesAndShow(String imagePath, Integer shopId, BigDecimal price, String remark);

    /**
     * 获取门店商品展示图
     * @param host host
     * @param shopId shopId
     * @param page
     * @param pageSize
     * @return List<ProductImageVO>
     */
    IPage<ProductImageVO> productImagesByShopId(String host, Integer shopId, Integer page, Integer pageSize);
}
