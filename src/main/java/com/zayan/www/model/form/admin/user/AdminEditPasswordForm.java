package com.zayan.www.model.form.admin.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AdminEditPasswordForm {

    @NotNull(message = "旧密码不能为空")
    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("登录账号")
    private String phone;

    @NotBlank(message = "旧密码不能为空")
    @ApiModelProperty("旧密码")
    private String passwordOld;

    @NotBlank(message = "新密码不能为空")
    @ApiModelProperty("新密码")
    private String passwordNew;

    @NotBlank(message = "确认密码不能为空")
    @ApiModelProperty("确认密码")
    private String passwordConfirm;

}
