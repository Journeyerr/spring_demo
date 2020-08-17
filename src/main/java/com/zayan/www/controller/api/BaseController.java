package com.zayan.www.controller.api;

import com.zayan.www.constant.enums.ErrorEnum;
import com.zayan.www.exception.auth.UnAuthorizedException;
import com.zayan.www.model.dto.user.api.BaseUser;
import com.zayan.www.model.entity.User;
import com.zayan.www.service.UserService;
import com.zayan.www.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class BaseController {

    @Autowired
    private UserService userService;

    protected User baseUser() {
        User user = userService.getById(RequestUtil.getUserIdFormContextToken());
        if (Objects.isNull(user)){
            throw new UnAuthorizedException(ErrorEnum.USER_EXCEPTION);
        }
        return user;
    }
}
