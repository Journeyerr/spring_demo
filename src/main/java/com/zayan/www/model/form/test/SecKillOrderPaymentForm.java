package com.zayan.www.model.form.test;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SecKillOrderPaymentForm {

    @NotBlank(message = "唯一标志不能为空")
    private String traceId;

    @NotNull(message = "用户不能为空")
    private Integer userId ;
}
