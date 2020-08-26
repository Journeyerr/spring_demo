package com.zayan.www.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zayan.www.model.entity.ProductImage;
import com.zayan.www.model.form.admin.product.ProductImageCreateForm;
import com.zayan.www.model.vo.api.product.ProductImageVO;

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
     * @param createForm createForm
     * @return ProductImageShow
     */
    ProductImage saveProductImage(ProductImageCreateForm createForm);

    /**
     * 获取门店商品展示图
     * @param shopId shopId
     * @param page
     * @param pageSize
     * @return List<ProductImageVO>
     */
    IPage<ProductImageVO> productImagesByShopId(Integer shopId, Integer page, Integer pageSize);
}
