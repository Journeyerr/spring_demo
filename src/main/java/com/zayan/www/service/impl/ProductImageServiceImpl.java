package com.zayan.www.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zayan.www.constant.common.aliyun.ALiYunOss;
import com.zayan.www.model.entity.ProductImage;
import com.zayan.www.model.form.admin.product.ProductImageCreateForm;
import com.zayan.www.model.vo.api.product.ProductImageVO;
import com.zayan.www.repository.ProductImageMapper;
import com.zayan.www.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AnYuan
 * @since 2020-08-17
 */
@Service
public class ProductImageServiceImpl extends ServiceImpl<ProductImageMapper, ProductImage> implements ProductImageService {

    @Override
    public ProductImage saveProductImage(ProductImageCreateForm createForm) {
        ProductImage productImage = new ProductImage();
        productImage.setImageId(createForm.getImageId());
        productImage.setShopId(createForm.getShopId());
        productImage.setPrice(createForm.getPrice());
        productImage.setRemark(createForm.getRemark());
        productImage.setStatus(createForm.getStatus());
        save(productImage);

        return productImage;
    }

    @Override
    public IPage<ProductImageVO> listRecord(Integer shopId, Integer status, Integer page, Integer pageSize) {

        IPage<ProductImageVO> imageVOIPage = this.baseMapper.list(shopId, status, new Page(page, pageSize));
        List<ProductImageVO> listVo = imageVOIPage.getRecords();
        if (CollectionUtils.isEmpty(listVo)) {
            return imageVOIPage;
        }
        listVo.forEach( v -> v.setProductImage(ALiYunOss.BUCKET + v.getProductImage()));
        return imageVOIPage;
    }
}
