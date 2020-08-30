package com.zayan.www.model.vo.api.product;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductVO {

    @ApiModelProperty("商品名称")
    @JsonProperty("name")
    private String name;

    @ApiModelProperty("商品图片id")
    @JsonProperty("image_id")
    private Integer imageId;

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
