package com.zayan.www.controller.admin;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zayan.www.model.entity.Shop;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.repository.ShopMapper;
import com.zayan.www.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
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
    private ShopMapper shopMapper;
    @Autowired
    private ShopService shopService;

    @GetMapping("/index")
    public BaseResult<IPage<Shop>> index(@RequestParam("page") Integer page,
                                         @RequestParam("pageSize") Integer pageSize) {
        return BaseResult.success(shopMapper.list(new Page(page, pageSize)));
    }

    @GetMapping("/list")
    public BaseResult<List<Shop>> index() {
        return BaseResult.success(shopService.shops());
    }
}


