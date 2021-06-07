package com.zayan.www.config.websocket;

import com.zayan.www.util.DateUtil;
import lombok.Data;

@Data
public class WebsocketMsgDTO {

    private String uid;
    private String toUId;
    private String content;
    private String dateTime;

    public WebsocketMsgDTO() {

    }

    public WebsocketMsgDTO(String uid, String toUId, String content) {
        this.uid = uid;
        this.toUId = toUId;
        this.content = content;
        this.dateTime = DateUtil.nowDateTimeString();
    }

    public WebsocketMsgDTO(String uid, String content) {
        this.uid = uid;
        this.content = content;
        this.dateTime = DateUtil.nowDateTimeString();
    }
}
