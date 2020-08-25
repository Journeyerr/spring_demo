package com.zayan.www.controller.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.model.vo.api.product.ProductImageVO;
import com.zayan.www.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductImageService productImageService;


    @GetMapping("/images")
    public BaseResult<IPage<ProductImageVO>> images(@RequestParam("shopId") Integer shopId,
                                                   @RequestParam("pageSize") Integer pageSize,
                                                   @RequestParam("page") Integer page) {

        IPage<ProductImageVO> imageVOIPage = productImageService.productImagesByShopId(shopId, page, pageSize);
        return BaseResult.success(imageVOIPage);
    }

}
