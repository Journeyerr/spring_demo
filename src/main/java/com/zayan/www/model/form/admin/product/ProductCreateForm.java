package com.zayan.www.model.form.admin.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductCreateForm {

    @ApiModelProperty("商品名称")
    private String name;

    @ApiModelProperty("商品价格")
    private BigDecimal price;

    @ApiModelProperty("商品数量")
    private Integer quantity = 1;

    @ApiModelProperty("商品单位")
    private String unit;

    @ApiModelProperty("图片id")
    private Integer imageId;

    @ApiModelProperty("门店id")
    private Integer shopId;

    @ApiModelProperty("商品描述")
    private String remark;

    @ApiModelProperty("是否显示")
    private Integer status;
}
