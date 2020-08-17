package com.zayan.www.model.form.user.api;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author AnYuan
 */

@Data
public class UserLoginForm {

    @NotNull(message = "用户名不能为空")
    @ApiModelProperty("用户名")
    private String userName;

    @NotNull(message = "密码不能为空")
    @ApiModelProperty("密码")
    private String password;
}
