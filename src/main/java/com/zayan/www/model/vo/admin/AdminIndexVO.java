package com.zayan.www.model.vo.admin;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 首页概况
 * @author AnYuan
 * @date 2020-08-26
 */

@Data
@Builder
public class AdminIndexVO {

    @ApiModelProperty("门店总数")
    private Integer shopCount;

    @ApiModelProperty("商品图片总数")
    @JsonProperty("productImageCount")
    private Integer productImageCount;
}
