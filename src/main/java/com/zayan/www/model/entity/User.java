package com.zayan.www.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
    private LocalDateTime lastLoginAt;

    /**
     * 记住登陆状态
     */
    private String rememberToken;

    /**
     * 测试用户字段
     */
    private Integer isVip;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;


}
