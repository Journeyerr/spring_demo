package com.zayan.www.model.vo;

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

    @ApiModelProperty("商品总数")
    @JsonProperty("productCount")
    private Integer productCount;

    @ApiModelProperty("banner总数")
    @JsonProperty("bannerCount")
    private Integer bannerCount;

    @ApiModelProperty("订单总数")
    @JsonProperty("orderCount")
    private Integer orderCount;
}
