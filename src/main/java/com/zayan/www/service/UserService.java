package com.zayan.www.service;

import com.zayan.www.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

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
     * 根据用户id获取用户
     * @param userId 用户id
     * @return user
     */
    User getUserById(Integer userId);
}
