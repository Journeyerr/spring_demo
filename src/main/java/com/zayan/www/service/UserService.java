package com.zayan.www.service;

import com.zayan.www.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author AnYuan
 * @since 2020-09-02
 */
public interface UserService extends IService<User> {

    /**
     * 根据openid登录获取token
     * @param openId openId
     * @param sessionKey sessionKey
     * @return token
     * @Exception WxErrorException
     */
    String wxLoginGetToken(String openId, String sessionKey) throws WxErrorException;
}
