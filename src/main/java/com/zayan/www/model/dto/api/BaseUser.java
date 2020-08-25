package com.zayan.www.model.dto.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseUser {

    private Integer userId;
    private String userName;
}
