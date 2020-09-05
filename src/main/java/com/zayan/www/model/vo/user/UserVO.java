package com.zayan.www.model.vo.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
public class UserVO {

    @JsonProperty("id")
    @ApiModelProperty("用户id")
    private Integer id;

    @JsonProperty("name")
    @ApiModelProperty("用户名称")
    private String name;

    @JsonProperty("image_url")
    @ApiModelProperty("用户头像")
    private String imageUrl;

    @JsonProperty("birthday")
    @ApiModelProperty("生日")
    private String birthday;

    @JsonProperty("phone")
    @ApiModelProperty("手机号码")
    private String phone;


    @JsonProperty("country")
    @ApiModelProperty("微信获取的国家名称")
    private String country;

    @JsonProperty("province")
    @ApiModelProperty("微信获取的省级名称")
    private String province;

    @JsonProperty("city")
    @ApiModelProperty("微信获取的城市名称")
    private String city;
}
