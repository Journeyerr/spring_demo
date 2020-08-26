package com.zayan.www.model.form.admin.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserLoginForm {

    @ApiModelProperty("登录账号")
    private String phone;

    @ApiModelProperty("密码")
    private String password;
}
