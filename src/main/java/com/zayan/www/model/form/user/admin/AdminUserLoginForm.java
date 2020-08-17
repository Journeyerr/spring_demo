package com.zayan.www.model.form.user.admin;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AdminUserLoginForm {

    @ApiModelProperty("登录账号")
    private String phone;

    @ApiModelProperty("密码")
    private String password;
}
