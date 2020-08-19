package com.zayan.www.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zayan.www.constant.common.ALiYunOss;
import com.zayan.www.model.entity.Image;
import com.zayan.www.model.entity.ProductImage;
import com.zayan.www.model.vo.ProductImageVO;
import com.zayan.www.repository.ProductImageMapper;
import com.zayan.www.service.ImageService;
import com.zayan.www.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    @Autowired
    private ImageService imageService;

    @Override
    public ProductImage saveImagesAndShow(String imagePath, Integer shopId, BigDecimal price, String remark) {

        Image image = new Image();
        image.setPath(imagePath);
        imageService.save(image);

        ProductImage productImage = new ProductImage();
        productImage.setImageId(image.getId());
        productImage.setShopId(shopId);
        productImage.setPrice(price);
        productImage.setRemark(remark);
        save(productImage);

        return productImage;
    }

    @Override
    public IPage<ProductImageVO> productImagesByShopId(Integer shopId, Integer page, Integer pageSize) {

        IPage<ProductImageVO> imageVOIPage = this.baseMapper.imagesList(new Page(page, pageSize), shopId);
        List<ProductImageVO> listVo = imageVOIPage.getRecords();
        if (CollectionUtils.isEmpty(listVo)) {
            return imageVOIPage;
        }
        listVo.forEach( v -> v.setProductImage(ALiYunOss.BUCKET + v.getProductImage()));
        return imageVOIPage;
    }
}
