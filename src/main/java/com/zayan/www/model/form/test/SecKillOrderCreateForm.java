package com.zayan.www.model.form.test;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SecKillOrderCreateForm {

    @NotNull(message = "skuNo不能为空")
    private Integer skuNo;
    @NotNull(message = "userId不能为空")
    private Integer userId;

    private String traceId;

}
