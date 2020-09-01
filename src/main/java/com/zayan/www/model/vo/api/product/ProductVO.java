package com.zayan.www.model.vo.api.product;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductVO {

    @ApiModelProperty("商品名称")
    @JsonProperty("name")
    private String name;

    @ApiModelProperty("商品图片id")
    @JsonProperty("image_id")
    private Integer imageId;
    @JsonProperty("id")
    private Integer id;

    @ApiModelProperty("门店id")
    @JsonProperty("shop_id")
    private Integer shopId;

    @ApiModelProperty("门店名称")
    @JsonProperty("shop_name")
    private String shopName;

    @ApiModelProperty("价格")
    @JsonProperty("price")
    private BigDecimal price;

    @ApiModelProperty("单元")
    @JsonProperty("unit")
    private String unit;

    @ApiModelProperty("单元数量")
    @JsonProperty("quantity")
    private BigDecimal quantity;

    @ApiModelProperty("描述")
    @JsonProperty("remark")
    private String remark;

    @ApiModelProperty("状态")
    @JsonProperty("status")
    private String status;

    @ApiModelProperty("图片url")
    @JsonProperty("product_image")
    private String productImage;

    @ApiModelProperty("创建时间")
    @JsonProperty("created_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
}
