package com.zayan.www.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MailUtil {

    private static final String FROM_MAIL = "test@163.com";

    @Autowired
    private JavaMailSender javaMailSender;

    public Boolean send(String to, String title, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(FROM_MAIL);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(title);
        simpleMailMessage.setText(content);

        log.info("邮件发送参数：{}", JSONObject.toJSONString(simpleMailMessage));
        try {
            javaMailSender.send(simpleMailMessage);
            log.info("邮件发送成功");
            return true;
        }catch (Exception e) {
            log.info("邮件发送失败：{}", e.getMessage());
            return false;
        }
    }
}
