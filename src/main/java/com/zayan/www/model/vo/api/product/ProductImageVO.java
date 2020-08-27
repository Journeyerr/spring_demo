package com.zayan.www.model.vo.api.product;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductImageVO {

    @ApiModelProperty("商品图片id")
    @JsonProperty("id")
    private Integer id;

    @ApiModelProperty("价格")
    @JsonProperty("price")
    private BigDecimal price;

    @ApiModelProperty("描述")
    @JsonProperty("remark")
    private String remark;

    @ApiModelProperty("图片url")
    @JsonProperty("product_image")
    private String productImage;

}
