package com.zayan.www.model.form.admin.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AdminLoginForm {

    @NotBlank(message = "账号不能为空")
    @ApiModelProperty("登录账号")
    private String phone;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty("密码")
    private String password;
}
