package com.zayan.www.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zayan.www.constant.common.aliyun.ALiYunOss;
import com.zayan.www.model.entity.Product;
import com.zayan.www.model.form.admin.product.ProductCreateForm;
import com.zayan.www.model.vo.api.product.ProductVO;
import com.zayan.www.repository.ProductMapper;
import com.zayan.www.service.ProductService;
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
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    public Product saveProduct(ProductCreateForm createForm) {
        Product product = new Product();
        product.setName(createForm.getName());
        product.setImageId(createForm.getImageId());
        product.setShopId(createForm.getShopId());
        product.setPrice(createForm.getPrice());
        product.setRemark(createForm.getRemark());
        product.setStatus(createForm.getStatus());
        save(product);

        return product;
    }

    @Override
    public IPage<ProductVO> listRecord(Integer shopId, Integer status, Integer page, Integer pageSize) {

        IPage<ProductVO> imageVOIPage = this.baseMapper.productsList(shopId, status, new Page(page, pageSize));
        List<ProductVO> listVo = imageVOIPage.getRecords();
        if (CollectionUtils.isEmpty(listVo)) {
            return imageVOIPage;
        }
        listVo.forEach( v -> v.setProductImage(ALiYunOss.BUCKET + v.getProductImage()));
        return imageVOIPage;
    }
}
