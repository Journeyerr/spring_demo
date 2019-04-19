package com.zayan.www.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zayan.www.model.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author AnYuan
 * @since 2019-04-15
 */
public interface UserService extends IService<User> {

    /**
     * 用户登录
     *
     * @param userName 帐号
     * @param password 密码
     * @return String token
     */
    String login(String userName, String password);

    /**
     * 根据用户id获取用户
     *
     * @param userId 用户id
     * @return user
     */
    User getUserById(Integer userId);
}