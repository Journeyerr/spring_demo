package com.zayan.www.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zayan.www.model.dto.admin.user.UserListDTO;
import com.zayan.www.model.entity.User;
import com.zayan.www.model.form.admin.UserListForm;

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
     * 获取用户列表
     * @param iPage 分页
     * @param listForm 筛选条件
     * @return 返回
     */
    IPage<UserListDTO> users(IPage iPage, UserListForm listForm);
}