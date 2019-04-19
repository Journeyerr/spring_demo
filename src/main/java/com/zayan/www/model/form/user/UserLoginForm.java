package com.zayan.www.model.form.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author AnYuan
 */

@Data
public class UserLoginForm {

    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String password;
}
