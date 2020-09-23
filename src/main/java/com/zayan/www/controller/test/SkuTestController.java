package com.zayan.www.controller.test;

import com.zayan.www.model.entity.Skus;
import com.zayan.www.model.entity.User;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.service.SkusService;
import com.zayan.www.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/test")
public class SkuTestController {

    @Autowired
    private SkusService skusService;
    @Autowired
    private UserService userService;

    @GetMapping("/sku/{id}")
    public BaseResult<?> skuTest(@PathVariable("id") Integer id) {
        Skus skus = skusService.getById(id);
        return BaseResult.success(skus);
    }

    @GetMapping("/sku/user/{id}")
    public BaseResult<?> userTest(@PathVariable("id") Integer id) {
        User user = userService.getById(id);
        return BaseResult.success(user);
    }

    @PostMapping("/sku")
    public BaseResult<?> skuTest() {
        Skus skus = new Skus();
        skus.setStock(1);
        skus.setVersion(1);
        skus.setNo(8001);
        skusService.save(skus);
        return BaseResult.success(skus);
    }

}
