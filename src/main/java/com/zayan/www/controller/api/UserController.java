package com.zayan.www.controller.api;

import com.google.common.collect.Maps;
import com.zayan.www.model.entity.User;
import com.zayan.www.model.form.user.UserLoginForm;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.service.UserService;
import com.zayan.www.util.RequestUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("")
    public BaseResult show(){
        Integer userId = RequestUtil.getUserInfoByToken();
        User user = userService.getById(userId);
        return BaseResult.success(user);
    }

    @PostMapping("/login")
    public BaseResult login(@Valid UserLoginForm loginForm){
        Map userMap = Maps.newHashMap();
        String token = userService.login(loginForm.getUserName(), loginForm.getPassword());
        userMap.put("token", token);
        return BaseResult.success(userMap);
    }

    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwidXNlciI6eyJ1c2VyTmFtZSI6IkNoYXJsb3R0ZSIsInVzZXJJZCI6MX0sImlhdCI6MTU1NTY4NjI2OSwibmJmIjoxNTU1Njg2MjY5LCJleHAiOjE1NTU2OTIyNjksImlzcyI6InpheWFuIn0.JSRLmi55hYrXUIsatOQv65q-FOnarrRAvFB_oD2Lpp0";
        String[] split = token.split("\\.");
        System.out.println(split[1]);
    }
}
