package com.zayan.www.controller.admin;


import com.google.common.collect.Maps;
import com.zayan.www.model.form.admin.AdminUserLoginForm;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.model.vo.admin.AdminUserInfoVO;
import com.zayan.www.service.AdminUserService;
import com.zayan.www.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("/user/login")
    public BaseResult<Map<String, String>> login(@RequestBody AdminUserLoginForm loginForm) {
        HashMap<String, String> map = Maps.newHashMapWithExpectedSize(1);
        String token = adminUserService.login(loginForm.getPhone(), loginForm.getPassword());
        map.put("token", token);
        return BaseResult.success(map);
    }

    @GetMapping("/user")
    public BaseResult<AdminUserInfoVO> userInfo() {
        return BaseResult.success(adminUserService.userInfo(RequestUtil.getUserIdFormContextToken()));
    }
}

