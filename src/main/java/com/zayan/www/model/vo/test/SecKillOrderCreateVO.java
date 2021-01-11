package com.zayan.www.model.vo.test;

import com.zayan.www.constant.enums.SecKillTraceIdStatusEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 秒杀标识
 */

@Data
public class SecKillOrderCreateVO {

    private String traceId;

    private String status;

    public SecKillOrderCreateVO() {
    }

    public SecKillOrderCreateVO(String traceId, SecKillTraceIdStatusEnum statusEnum) {
        this.traceId = traceId;
        this.status = statusEnum.getCode();
    }
}
