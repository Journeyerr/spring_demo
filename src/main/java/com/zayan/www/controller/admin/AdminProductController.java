package com.zayan.www.controller.admin;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zayan.www.model.entity.ProductImage;
import com.zayan.www.model.form.admin.product.ProductImageCreateForm;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.model.vo.api.product.ProductImageVO;
import com.zayan.www.service.ProductImageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private ProductImageService productImageService;

    @ApiOperation("商品图片列表")
    @GetMapping("/index")
    public BaseResult<IPage<ProductImageVO>> index(@RequestParam(value = "shopId", required = false) Integer shopId,
                                                   @RequestParam("page") Integer page,
                                                   @RequestParam("pageSize") Integer pageSize ) {

        return BaseResult.success(productImageService.listRecord(shopId, null,  page, pageSize));
    }


    @ApiOperation("创建商品图片")
    @PostMapping("/store")
    public BaseResult<ProductImageVO> store(@RequestBody ProductImageCreateForm createForm){
        ProductImage productImage = productImageService.saveProductImage(createForm);
        ProductImageVO productImageVO = ProductImageVO.builder()
                .price(productImage.getPrice())
                .remark(productImage.getRemark())
                .id(productImage.getId())
                .build();

        return BaseResult.success(productImageVO);
    }

}

