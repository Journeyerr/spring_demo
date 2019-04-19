package com.zayan.www.service.impl;

import com.zayan.www.model.entity.User;
import com.zayan.www.repository.UserMapper;
import com.zayan.www.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author AnYuan
 * @since 2019-04-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private UserMapper userMapper;

    @Override
    public User getUserById(Integer userId) {
        return this.getById(userId);
    }
}
