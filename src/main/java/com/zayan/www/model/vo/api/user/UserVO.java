package com.zayan.www.model.vo.api.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserVO {

    @JsonProperty("id")
    @ApiModelProperty("用户id")
    private Integer id;

    @JsonProperty("user_name")
    @ApiModelProperty("用户名称")
    private String userName;

    @JsonProperty("image_url")
    @ApiModelProperty("用户头像")
    private String imageUrl;

    @JsonProperty("birthday")
    @ApiModelProperty("生日")
    private String birthday;

    @JsonProperty("phone")
    @ApiModelProperty("手机号码")
    private String phone;
}
