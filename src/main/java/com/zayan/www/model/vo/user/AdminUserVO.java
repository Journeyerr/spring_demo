package com.zayan.www.model.vo.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminUserVO {

    @ApiModelProperty("用户id")
    @JsonProperty("id")
    private Integer id;

    @ApiModelProperty("用户名称")
    @JsonProperty("name")
    private String name;

    @ApiModelProperty("用户手机")
    @JsonProperty("phone")
    private String phone;
}
