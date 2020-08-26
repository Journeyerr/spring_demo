package com.zayan.www.controller.admin;

import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.model.vo.admin.AdminIndexVO;
import com.zayan.www.service.ProductImageService;
import com.zayan.www.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date 2020-08-26
 * @author AnYuan
 */

@RestController
@RequestMapping("admin/index")
public class AdminIndexController {

    @Autowired
    private ShopService shopService;
    @Autowired
    private ProductImageService productImageService;

    @GetMapping("")
    public BaseResult<AdminIndexVO> index() {
        AdminIndexVO indexVO = AdminIndexVO.builder()
                .shopCount(shopService.count())
                .productImageCount(productImageService.count())
                .build();

        return BaseResult.success(indexVO);
    }
}
