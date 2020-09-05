package com.zayan.www.model.form.api;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author AnYuan
 */

@Data
public class UserUpdateInfoForm {

    @ApiModelProperty("用户名")
    private String nickName;

    @ApiModelProperty("性别")
    private Integer gender;

    @ApiModelProperty("城市名称")
    private String city;

    @ApiModelProperty("省名称")
    private String province;

    @ApiModelProperty("国家名称")
    private String country;

    @ApiModelProperty("头像")
    private String avatarUrl;


    public static String coverGender(Integer gender) {
        switch (gender) {
            case 1:
                return "male";
            case 2:
                return "female";
            default:
                return "unknow";
        }
    }
}
