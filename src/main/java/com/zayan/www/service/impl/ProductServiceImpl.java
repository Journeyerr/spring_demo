package com.zayan.www.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zayan.www.constant.common.aliyun.ALiYunOss;
import com.zayan.www.constant.enums.ErrorEnum;
import com.zayan.www.exception.BaseException;
import com.zayan.www.model.entity.Product;
import com.zayan.www.model.form.admin.product.ProductCreateForm;
import com.zayan.www.model.form.admin.product.ProductEditForm;
import com.zayan.www.model.vo.product.ProductVO;
import com.zayan.www.repository.ProductMapper;
import com.zayan.www.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author AnYuan
 * @since 2020-08-17
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {


    private Product buildProduct(Product product, ProductCreateForm createForm) {

        product.setName(createForm.getName());
        product.setImageId(createForm.getImageId());
        product.setShopId(createForm.getShopId());
        product.setPrice(createForm.getPrice());
        product.setRemark(createForm.getRemark());
        product.setStatus(createForm.getStatus());
        product.setQuantity(createForm.getQuantity());
        product.setUnit(createForm.getUnit());
        product.setSort(createForm.getSort());

        return product;
    }

    @Override
    public Product saveProduct(ProductCreateForm createForm) {
        Product product = buildProduct(new Product(), createForm);
        save(product);
        return product;
    }

    @Override
    public IPage<ProductVO> listRecord(Integer page, Integer pageSize, Integer shopId, Integer status, String keyWord) {

        IPage<ProductVO> imageVOIPage = this.baseMapper.productsList(new Page(page, pageSize), shopId, status, keyWord);
        List<ProductVO> listVo = imageVOIPage.getRecords();
        if (!listVo.isEmpty()) {
            listVo.forEach(v -> v.setProductImage(ALiYunOss.BUCKET + v.getProductImage()));
        }
        return imageVOIPage;
    }

    @Override
    public Product editProduct(ProductEditForm editFormForm) {
        Product product = getById(editFormForm.getId());
        if (Objects.isNull(product)) {
            throw new BaseException(ErrorEnum.PARAM_ERROR);
        }

        buildProduct(product, editFormForm);
        updateById(product);
        return product;
    }
}
