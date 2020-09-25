package com.zayan.www.model.form.test;

import lombok.Data;

import java.util.Date;

@Data
public class WebsocketForm {

    private String from;

    private String to;

    private String content;

    private Date time;

}
