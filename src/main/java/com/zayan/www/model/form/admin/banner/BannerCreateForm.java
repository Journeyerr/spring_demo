package com.zayan.www.model.form.admin.banner;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class BannerCreateForm {

    @ApiModelProperty("图片id")
    private Integer imageId;

    @ApiModelProperty("商品id")
    private Integer productId;

    @ApiModelProperty("门店id")
    private Integer shopId;

    @ApiModelProperty("状态")
    private Integer status;
}
