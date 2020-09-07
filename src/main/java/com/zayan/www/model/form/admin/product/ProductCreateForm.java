package com.zayan.www.model.form.admin.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ProductCreateForm {

    @ApiModelProperty("商品名称")
    @NotBlank(message = "商品名称不能为空")
    private String name;

    @ApiModelProperty("商品价格")
    @NotNull(message = "商品价格不能为空")
    private BigDecimal price;

    @ApiModelProperty("商品数量")
    @NotNull(message = "商品数量不能为空")
    private Integer quantity = 1;

    @ApiModelProperty("商品单位")
    @NotBlank(message = "商品单位不能为空")
    private String unit;

    @ApiModelProperty("图片id")
    private Integer imageId;

    @ApiModelProperty("门店id")
    @NotNull(message = "门店不能为空")
    private Integer shopId;

    @ApiModelProperty("商品描述")
    private String remark;

    @ApiModelProperty("是否显示")
    private Integer status;

    @ApiModelProperty("排序")
    private Integer sort;
}
