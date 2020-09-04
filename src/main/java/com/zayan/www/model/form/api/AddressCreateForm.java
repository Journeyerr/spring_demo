package com.zayan.www.model.form.api;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddressCreateForm {

    @NotNull(message = "用户名不能为空")
    @ApiModelProperty("用户名")
    private String name;

    @NotNull(message = "号码不能为空")
    @ApiModelProperty("号码")
    private String phone;

    @NotNull(message = "地址信息不能为空")
    @ApiModelProperty("地址信息")
    private String address;
}
