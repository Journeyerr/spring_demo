package com.zayan.www.service.impl;

import com.zayan.www.model.entity.Image;
import com.zayan.www.model.entity.ProductImageShow;
import com.zayan.www.repository.ImageMapper;
import com.zayan.www.repository.ProductImageShowMapper;
import com.zayan.www.service.ImageService;
import com.zayan.www.service.ProductImageShowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AnYuan
 * @since 2020-08-17
 */
@Service
public class ProductImageShowServiceImpl extends ServiceImpl<ProductImageShowMapper, ProductImageShow> implements ProductImageShowService {

    @Autowired
    private ImageService imageService;

    @Override
    public ProductImageShow saveImagesAndShow(String imagePath, BigDecimal price, String remark) {

        Image image = new Image();
        image.setPath(imagePath);
        imageService.save(image);

        ProductImageShow productImageShow = new ProductImageShow();
        productImageShow.setImageId(image.getId());
        productImageShow.setPrice(price);
        productImageShow.setRemark(remark);

        save(productImageShow);

        return productImageShow;
    }
}
