package com.zayan.www.controller.admin;

import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.model.vo.AdminIndexVO;
import com.zayan.www.service.BannerService;
import com.zayan.www.service.OrderService;
import com.zayan.www.service.ProductService;
import com.zayan.www.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    private ProductService productService;
    @Autowired
    private BannerService bannerService;
    @Autowired
    private OrderService OrderService;

    @GetMapping("")
    public BaseResult<AdminIndexVO> index() {

        List<AdminIndexVO.Info> infos = new ArrayList<>();

        infos.add(AdminIndexVO.coverInfo("门店总数", shopService.count()));
        infos.add(AdminIndexVO.coverInfo("商品总数", productService.count()));
        infos.add(AdminIndexVO.coverInfo("banner总数", bannerService.count()));
        infos.add(AdminIndexVO.coverInfo("订单总数", OrderService.count()));

        AdminIndexVO indexVO = AdminIndexVO.builder()
                .infos(infos)
                .build();

        return BaseResult.success(indexVO);
    }
}
