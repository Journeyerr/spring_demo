package com.zayan.www.controller.admin;


import com.zayan.www.model.entity.ProductImageShow;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.service.ProductImageShowService;
import com.zayan.www.service.UploadService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

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
public class ProductImageShowController {

    @Autowired
    private UploadService uploadService;

    @Autowired
    private ProductImageShowService productImageShowService;

    @ApiOperation("创建商品图片")
    @PostMapping("/store")
    public BaseResult<ProductImageShow> store(@RequestParam("file") MultipartFile multipartFile,
                                              @RequestParam("price") BigDecimal price,
                                              @RequestParam("describe") String remark){
        String imagePath = uploadService.fileUpload(multipartFile);
        ProductImageShow productImageShow = productImageShowService.saveImagesAndShow(imagePath, price, remark);
        return BaseResult.success(productImageShow);
    }
}

