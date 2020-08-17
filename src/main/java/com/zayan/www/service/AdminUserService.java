package com.zayan.www.service;

import com.zayan.www.model.entity.AdminUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author AnYuan
 * @since 2020-08-17
 */
public interface AdminUserService extends IService<AdminUser> {

    /**
     * 用户登录
     *
     * @param phone 帐号
     * @param password 密码
     * @return String token
     */
    String login(String phone, String password);
}
