package com.zayan.www.model.form.admin.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductEditForm extends ProductCreateForm {

    @ApiModelProperty("商品id")
    private String id;
}
