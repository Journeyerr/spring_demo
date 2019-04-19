package com.zayan.www.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Maps;
import com.zayan.www.config.secure.JwtTokenProvider;
import com.zayan.www.constant.enums.ErrorEnum;
import com.zayan.www.exception.order.OrderException;
import com.zayan.www.model.entity.User;
import com.zayan.www.repository.UserMapper;
import com.zayan.www.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

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

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public String login(String userName, String password) {
        User user = this.getOne(new QueryWrapper<User>()
                .lambda()
                .eq(User::getName, userName)
                .eq(User::getPhone, password));
        if (user == null){
            throw new OrderException(ErrorEnum.NO_FOUND);
        }
        Map userMap = Maps.newHashMap();
        userMap.put("userId",user.getId());
        userMap.put("userName",user.getName());
        Date date = new Date();
        Date expireTime = new Date(date.getTime() + 2 * 60);
        return jwtTokenProvider.createTokenWithExpiration(user.getId().toString(), userMap, expireTime);
    }

    @Override
    public User getUserById(Integer userId) {
        return this.getById(userId);
    }
}
