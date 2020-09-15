package com.zayan.www.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 首页概况
 * @author AnYuan
 * @date 2020-08-26
 */

@Data
@Builder
public class AdminIndexVO {

    private List<Info> infos;

    @Data
    public static class Info{
        private String name;
        private Integer count;
    }


    public static Info coverInfo(String name, Integer count) {
        Info info = new Info();
        info.setName(name);
        info.setCount(count);
        return info;
    }

}
