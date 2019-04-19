package com.zayan.www.controller;

import com.zayan.www.constant.enums.ErrorEnum;
import com.zayan.www.model.entity.User;
import com.zayan.www.model.vo.BaseResult;
import com.zayan.www.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/test")
    public BaseResult test(){
        User user = userService.getUserById(1);
        return BaseResult.success(user);
    }

    @GetMapping("/error")
    public BaseResult error(){
        return BaseResult.error(ErrorEnum.NO_FOUND);
    }
}
