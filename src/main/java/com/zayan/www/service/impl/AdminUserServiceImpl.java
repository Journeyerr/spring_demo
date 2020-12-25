package com.zayan.www.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Maps;
import com.zayan.www.config.secure.JwtTokenProvider;
import com.zayan.www.constant.enums.ErrorEnum;
import com.zayan.www.exception.user.UserExcetpion;
import com.zayan.www.model.entity.AdminUser;
import com.zayan.www.model.form.admin.user.AdminEditPasswordForm;
import com.zayan.www.model.vo.user.AdminUserVO;
import com.zayan.www.repository.AdminUserMapper;
import com.zayan.www.service.AdminUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zayan.www.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.validation.constraints.NotBlank;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author AnYuan
 * @since 2020-08-17
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Value("${admin.sale}")
    private String sale;

    @Override
    public String login(String phone, String password) {

        AdminUser adminUser = this.getOne(new QueryWrapper<AdminUser>()
                .lambda()
                .eq(AdminUser::getPhone, phone)
                .eq(AdminUser::getPassword, DigestUtils.md5DigestAsHex(password.concat(sale).getBytes())));

        if (Objects.isNull(adminUser)) {
            throw new UserExcetpion(ErrorEnum.ACCOUNT_ERROR);
        }

        Map<String, Object> userMap = Maps.newHashMap();
        userMap.put("userId", adminUser.getId());
        return jwtTokenProvider.createTokenWithExpiration(userMap, null);
    }

    @Override
    public AdminUserVO userInfo(Integer userId) {
        AdminUser adminUser = getById(userId);
        if (Objects.isNull(adminUser)) {
            throw new UserExcetpion(ErrorEnum.TOKEN_EXCEPTION);
        }

        return AdminUserVO.builder()
                .id(adminUser.getId())
                .name(adminUser.getUserName())
                .phone(adminUser.getPhone())
                .build();
    }

    @Override
    public AdminUserVO editPassword(AdminEditPasswordForm form) {

        if (!form.getPasswordNew().equals(form.getPasswordConfirm())) {
            throw new UserExcetpion(ErrorEnum.EDIT_PASSWORD_NO_EQUALS);
        }
        AdminUser adminUser = getById(form.getId());
        if (!adminUser.getPassword().equals(StringUtil.md5(form.getPasswordOld() + sale))) {
            throw new UserExcetpion(ErrorEnum.EDIT_PASSWORD_ERROR);
        }
        adminUser.setPassword(StringUtil.md5(form.getPasswordNew() + sale));
        updateById(adminUser);

        return userInfo(adminUser.getId());
    }
}
