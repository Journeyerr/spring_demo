package com.zayan.www.controller.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zayan.www.constant.common.aliyun.ALiYunOss;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.model.vo.product.ProductVO;
import com.zayan.www.repository.ProductMapper;
import com.zayan.www.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.tools.jconsole.Worker;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;


    @GetMapping("/index")
    public BaseResult<IPage<ProductVO>> images(@RequestParam("shopId") Integer shopId,
                                               @RequestParam(value = "keyWord", required = false) String keyWord,
                                               @RequestParam("pageSize") Integer pageSize,
                                               @RequestParam("page") Integer page) {
        System.out.println(keyWord);
        IPage<ProductVO> imageVOIPage = productService.listRecord(page, pageSize, shopId, 1, keyWord);
        return BaseResult.success(imageVOIPage);
    }

    @GetMapping("detail/{productId}")
    public BaseResult<ProductVO> images(@PathVariable("productId") Integer productId) {
        ProductVO detail = productMapper.detail(productId);
        detail.setProductImage(ALiYunOss.BUCKET + detail.getProductImage());
        return BaseResult.success(detail);
    }

}
