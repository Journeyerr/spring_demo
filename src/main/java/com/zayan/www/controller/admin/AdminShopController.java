package com.zayan.www.controller.admin;


import com.zayan.www.model.entity.Shop;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 门店表
 * </p>
 *
 * @author AnYuan
 * @since 2019-05-25
 */
@RestController
@RequestMapping("/admin/shop")
public class AdminShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/index")
    public BaseResult<List<Shop>> index() {
        return BaseResult.success(shopService.shops());
    }



}


