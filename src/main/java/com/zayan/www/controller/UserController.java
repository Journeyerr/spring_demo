package com.zayan.www.controller;

import com.google.common.collect.Maps;
import com.zayan.www.model.entity.User;
import com.zayan.www.model.form.user.UserLoginForm;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author AnYuan
 */

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public User show(@PathVariable("id") Integer userId){
        return userService.getUserById(userId);
    }

    @PostMapping("/login")
    public BaseResult login(@Valid UserLoginForm loginForm){
        Map userMap = Maps.newHashMap();
        String token = userService.login(loginForm.getUserName(), loginForm.getPassword());
        userMap.put("token", token);
        return BaseResult.success(userMap);
    }
}
