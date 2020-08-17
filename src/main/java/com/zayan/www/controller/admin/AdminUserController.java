package com.zayan.www.controller.admin;


import com.google.common.collect.Maps;
import com.zayan.www.model.form.user.admin.AdminUserLoginForm;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author AnYuan
 * @since 2020-08-17
 */
@RestController
@RequestMapping("/adminUser")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("/login")
    public BaseResult<Map<String, String>> login(@RequestBody AdminUserLoginForm loginForm) {
        HashMap<String, String> map = Maps.newHashMapWithExpectedSize(1);
        String token = adminUserService.login(loginForm.getPhone(), loginForm.getPassword());
        map.put("token", token);
        return BaseResult.success(map);
    }
}

