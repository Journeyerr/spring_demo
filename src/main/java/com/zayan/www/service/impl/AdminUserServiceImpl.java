package com.zayan.www.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Maps;
import com.zayan.www.config.secure.JwtTokenProvider;
import com.zayan.www.constant.enums.ErrorEnum;
import com.zayan.www.exception.user.UserExcetpion;
import com.zayan.www.model.entity.AdminUser;
import com.zayan.www.model.entity.User;
import com.zayan.www.model.vo.admin.AdminUserInfoVO;
import com.zayan.www.repository.AdminUserMapper;
import com.zayan.www.service.AdminUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Map;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AnYuan
 * @since 2020-08-17
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Value("${sale.admin}")
    private String sale;

    @Override
    public String login(String phone, String password) {

        AdminUser adminUser = this.getOne(new QueryWrapper<AdminUser>()
                .lambda()
                .eq(AdminUser::getPhone, phone)
                .eq(AdminUser::getPassword, DigestUtils.md5DigestAsHex(password.concat(sale).getBytes())));

        if (Objects.isNull(adminUser)){
            throw new UserExcetpion(ErrorEnum.ACCOUNT_ERROR);
        }

        Map<String, Object> userMap = Maps.newHashMap();
        userMap.put("userId", adminUser.getId());
        return jwtTokenProvider.createTokenWithExpiration(adminUser.getId(), userMap, null);
    }

    @Override
    public AdminUserInfoVO userInfo(Integer userId) {
        AdminUser adminUser = getById(userId);
        if (Objects.isNull(adminUser)) {
            throw new UserExcetpion(ErrorEnum.TOKEN_EXCEPTION);
        }

        return AdminUserInfoVO.builder()
                .id(adminUser.getId())
                .name(adminUser.getUserName())
                .phone(adminUser.getPhone())
                .build();
    }
}
