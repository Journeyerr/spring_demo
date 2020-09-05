package com.zayan.www.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Maps;
import com.zayan.www.config.secure.JwtTokenProvider;
import com.zayan.www.model.entity.User;
import com.zayan.www.repository.UserMapper;
import com.zayan.www.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author AnYuan
 * @since 2020-09-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Transactional(rollbackFor = {WxErrorException.class})
    @Override
    public String wxLoginGetToken(String openId, String sessionKey){

        User userOne = getOne(new QueryWrapper<User>().lambda().eq(User::getWxOpenId, openId));
        Map<String, Object> userMap = Maps.newHashMap();
        if (Objects.isNull(userOne)) {
            User user = new User();
            user.setWxOpenId(openId);
            user.setWxSessionKey(sessionKey);
            user.setLastLoginAt(LocalDateTime.now());
            save(user);
            userMap.put("userId", user.getId());
        }else {
            userOne.setLastLoginAt(LocalDateTime.now());
            updateById(userOne);
            userMap.put("userId", userOne.getId());
        }
        return jwtTokenProvider.createTokenWithExpiration(userMap, null);
    }
}
