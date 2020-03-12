package com.zayan.www.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author AnYuan
 * @since 2019-04-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("users")
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 加密后的手机号
     */
    private String phoneShow;

    /**
     * 生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    /**
     * 头像id
     */
    private Integer avatarId;

    /**
     * 微信头像url
     */
    private String imageUrl;

    /**
     * 性别
     */
    private String sex;

    /**
     * 小程序session
     */
    private String wxliteSessionKey;

    /**
     * 小程序openid
     */
    private String wxliteOpenId;

    /**
     * 微信unionid
     */
    private String wxUnionId;

    /**
     * 极光推送设备号id
     */
    private String jpushId;

    /**
     * 微信备注地区
     */
    private String district;

    /**
     * 密码
     */
    private String password;

    /**
     * 最后登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLoginAt;

    /**
     * 记住登陆状态
     */
    private String rememberToken;

    /**
     * 测试用户字段
     */
    private Integer isVip;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;


}
