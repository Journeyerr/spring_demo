package com.zayan.www.controller.admin;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zayan.www.constant.enums.ErrorEnum;
import com.zayan.www.exception.BaseException;
import com.zayan.www.model.entity.ProductImage;
import com.zayan.www.model.form.admin.product.ProductImageCreateForm;
import com.zayan.www.model.entity.Product;
import com.zayan.www.model.form.admin.product.ProductCreateForm;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.model.vo.api.product.ProductVO;
import com.zayan.www.service.ProductService;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author AnYuan
 * @since 2020-08-17
 */
@RestController
@RequestMapping("admin/product/images")
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("商品图片列表")
    @GetMapping("/index")
    public BaseResult<IPage<ProductImageVO>> index(@RequestParam(value = "shopId", required = false) Integer shopId,
                                                   @RequestParam("page") Integer page,
                                                   @RequestParam("pageSize") Integer pageSize ) {

        return BaseResult.success(productImageService.listRecord(shopId, null,  page, pageSize));
    }


    @ApiOperation("创建商品")
    @PostMapping("/store")
    public BaseResult<ProductVO> store(@RequestBody ProductCreateForm createForm){
        Product product = productService.saveProduct(createForm);

        ProductVO productVO = new ProductVO();
        productVO.setPrice(product.getPrice());
        productVO.setName(product.getName());
        productVO.setRemark(product.getRemark());
        productVO.setImageId(product.getImageId());

        return BaseResult.success(productVO);
    }

    @ApiOperation("删除商品图片")
    @PostMapping("/delete/{imageId}")
    public BaseResult<?> delete(@PathVariable("imageId") Integer imageId){
        ProductImage productImage = productImageService.getById(imageId);

        if (Objects.isNull(productImage)) {
            throw new BaseException(ErrorEnum.UPDATE_FAIL);
        }
        productImage.setDeletedAt(LocalDateTime.now());
        productImageService.updateById(productImage);
        return BaseResult.success();
    }

    @ApiOperation("更新商品图片状态")
    @PostMapping("/update/{imageId}")
    public BaseResult<?> update(@PathVariable("imageId") Integer imageId){
        ProductImage productImage = productImageService.getById(imageId);

        if (Objects.isNull(productImage)) {
            throw new BaseException(ErrorEnum.UPDATE_FAIL);
        }
        productImage.setStatus(productImage.getStatus().equals(1) ? 0 : 1);
        productImageService.updateById(productImage);
        return BaseResult.success();
    }
}

