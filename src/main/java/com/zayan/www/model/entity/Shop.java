package com.zayan.www.model.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author AnYuan
 * @since 2020-08-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("shops")
public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 门店名称
     */
    private String name;

    /**
     * 门店编码
     */
    private String no;

    /**
     * 门店启停1为启用
     */
    private Integer isEnable;

    /**
     * 国家名称
     */
    private String country;

    /**
     * 省级名称
     */
    private String province;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 城市名称
     */
    private String city;

    /**
     * 城市code
     */
    private String cityCode;

    /**
     * 区域名称
     */
    private String district;

    /**
     * 区号
     */
    private String districtCode;

    /**
     * 门店地址
     */
    private String address;

    /**
     * 纬度
     */
    private String longitude;

    /**
     * 经度
     */
    private String latitude;

    /**
     * 开店时间
     */
    private String openAt;

    /**
     * 关店时间
     */
    private String closeAt;

    /**
     * 外卖配送距离
     */
    private Integer deliveryDistance;

    /**
     * 外卖配送费
     */
    private BigDecimal deliveryFee;

    /**
     * 外卖状态 0关1开
     */
    private Integer takeawayStatus;

    /**
     * 门店提示语
     */
    private String tips;

    /**
     * 门店二维码
     */
    private String qrCode;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;


}
