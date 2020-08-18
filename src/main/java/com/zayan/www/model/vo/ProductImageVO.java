package com.zayan.www.model.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductImageVO {

    @ApiModelProperty("价格")
    @JsonProperty("price")
    private BigDecimal price;

    @ApiModelProperty("描述")
    @JsonProperty("remark")
    private String remark;

    @ApiModelProperty("图片url")
    @JsonProperty("product_image_url")
    private String productImageUrl;

}
