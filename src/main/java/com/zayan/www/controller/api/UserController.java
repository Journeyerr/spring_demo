package com.zayan.www.controller.api;

import com.google.common.collect.Maps;
import com.zayan.www.model.entity.User;
import com.zayan.www.model.form.user.api.UserLoginForm;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.service.UserService;
import com.zayan.www.util.RequestUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author AnYuan
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public BaseResult show(){
        Integer userId = RequestUtil.getUserInfoByToken();
        User user = userService.getById(userId);
        return BaseResult.success(user);
    }

    @PostMapping("/login")
    public BaseResult login(@Valid @RequestBody UserLoginForm loginForm){
        Map userMap = Maps.newHashMap();
        String token = userService.login(loginForm.getUserName(), loginForm.getPassword());
        userMap.put("token", token);
        return BaseResult.success(userMap);
    }
}
