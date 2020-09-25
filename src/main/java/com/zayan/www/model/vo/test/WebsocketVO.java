package com.zayan.www.model.vo.test;

import lombok.Data;

import java.util.Date;

@Data
public class WebsocketVO {

    private String from;

    private String content;

    private Date time = new Date();

    public WebsocketVO(String content) {
        this.content = content;
    }
}
