package com.zayan.www.controller.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.model.vo.ProductImageVO;
import com.zayan.www.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductImageService productImageService;


    @GetMapping("/images")
    public BaseResult<IPage<ProductImageVO>> images(HttpServletRequest request,
                                                   @RequestParam("shopId") Integer shopId,
                                                   @RequestParam("pageSize") Integer pageSize,
                                                   @RequestParam("page") Integer page) {

        String host = request.getScheme() + "://" + request.getServerName()
                + ":" +request.getServerPort() + "/";
        IPage<ProductImageVO> imageVOIPage = productImageService.productImagesByShopId(host, shopId, page, pageSize);
        return BaseResult.success(imageVOIPage);
    }

}
