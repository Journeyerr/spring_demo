package com.zayan.www.controller.api;

import com.google.common.collect.Maps;
import com.zayan.www.model.form.user.api.UserLoginForm;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author AnYuan
 */

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public BaseResult<?> login(@Valid @RequestBody UserLoginForm loginForm){
        Map<String, String> userMap = Maps.newHashMap();
        String token = userService.login(loginForm.getUserName(), loginForm.getPassword());
        userMap.put("token", token);
        return BaseResult.success(userMap);
    }

    @ApiOperation("用户信息")
    @GetMapping("")
    public BaseResult<?> show(){
        return BaseResult.success(userService.getById(baseUser().getUserId()));
    }
}
