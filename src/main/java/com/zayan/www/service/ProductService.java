package com.zayan.www.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zayan.www.model.entity.Product;
import com.zayan.www.model.form.admin.product.ProductCreateForm;
import com.zayan.www.model.vo.product.ProductVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author AnYuan
 * @since 2020-08-17
 */
public interface ProductService extends IService<Product> {

    /**
     * 保存图片路径 和 商品图片
     * @param createForm createForm
     * @return ProductImageShow
     */
    Product saveProduct(ProductCreateForm createForm);

    /**
     * 获取门店商品展示图
     * @param shopId shopId
     * @param status status
     * @param page page
     * @param pageSize pageSize
     * @return List<ProductVO>
     */
    IPage<ProductVO> listRecord(Integer shopId, Integer status, Integer page, Integer pageSize);
}
