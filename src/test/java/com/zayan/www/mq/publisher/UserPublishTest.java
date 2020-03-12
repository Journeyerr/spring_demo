package com.zayan.www.mq.publisher;

import com.zayan.www.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPublishTest {

    @Autowired
    private UserPublish userPublish;
    @Autowired
    private UserService userService;

    @Test
    public void userSendTest() {
        userPublish.send(userService.getById(1));
    }

}