package com.zayan.www.controller.admin;


import com.zayan.www.model.entity.ProductImage;
import com.zayan.www.model.form.admin.product.ProductImageCreateForm;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.model.vo.api.product.ProductImageVO;
import com.zayan.www.service.ProductImageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author AnYuan
 * @since 2020-08-17
 */
@RestController
@RequestMapping("admin/product/image")
public class AdminProductController {

    @Autowired
    private ProductImageService productImageService;

    @ApiOperation("创建商品图片")
    @PostMapping("/store")
    public BaseResult<ProductImageVO> store(@RequestBody ProductImageCreateForm createForm){
        ProductImage productImage = productImageService.saveProductImage(createForm);
        ProductImageVO productImageVO = ProductImageVO.builder()
                .price(productImage.getPrice())
                .remark(productImage.getRemark())
                .productImageId(productImage.getId())
                .build();

        return BaseResult.success(productImageVO);
    }
}

