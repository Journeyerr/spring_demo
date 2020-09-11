package com.zayan.www.controller.admin;


import com.google.common.collect.Maps;
import com.zayan.www.model.form.admin.user.AdminEditPasswordForm;
import com.zayan.www.model.form.admin.user.AdminLoginForm;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.model.vo.user.AdminUserVO;
import com.zayan.www.service.AdminUserService;
import com.zayan.www.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("/login")
    public BaseResult<Map<String, String>> login(@Valid @RequestBody AdminLoginForm loginForm) {
        HashMap<String, String> map = Maps.newHashMapWithExpectedSize(1);
        String token = adminUserService.login(loginForm.getPhone(), loginForm.getPassword());
        map.put("token", token);
        return BaseResult.success(map);
    }

    @GetMapping("")
    public BaseResult<AdminUserVO> userInfo() {
        return BaseResult.success(adminUserService.userInfo(RequestUtil.getUserIdFormContextToken()));
    }

    @PostMapping("/edit/password")
    public BaseResult<AdminUserVO> editPassword(@Valid @RequestBody AdminEditPasswordForm editPasswordForm) {
        return BaseResult.success(adminUserService.editPassword(editPasswordForm));
    }
}

