package com.zayan.www.model.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 门店表
 * </p>
 *
 * @author AnYuan
 * @since 2019-05-25
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
     * 门店编号
     */
    private String code;

    /**
     * 店名
     */
    private String name;

    /**
     * 关键字
     */
    private String addressKeyword;

    private Integer coverPicId;

    private Integer outerId;

    /**
     * 策略ID
     */
    private Integer policyId;

    /**
     * 公司ID
     */
    private Integer companyId;

    /**
     * 门店编码
     */
    private String no;

    /**
     * 营业/休息状态
     */
    private Boolean isActived;

    /**
     * 门店启停1为启用
     */
    private Integer isEnable;

    /**
     * 门店状态标签0：敬请期待,1:已经开启门店
     */
    private Integer isOpen;

    /**
     * 是否同步线下订单
     */
    private Boolean isSyncPosOrder;

    private String contactPhone;

    private String contactName;

    /**
     * 国家名称
     */
    private String country;

    /**
     * 国家代码
     */
    private String countryCode;

    private String province;

    /**
     * 城市
     */
    private String city;

    private String district;

    /**
     * 区号
     */
    private String districtCode;

    /**
     * 地址
     */
    private String address;

    private String gaodeCityCode;

    /**
     * 城市编号
     */
    private String cityCode;

    private String latitude;

    private String longitude;

    /**
     * 门店订单杯数限制
     */
    private Integer cupLimit;

    private Integer beforeMinutes;

    private String daysOfWeek;

    private Integer timeInterval;

    private Integer unitBoxSeconds;

    private Integer unitBoxShares;

    /**
     * 起送价
     */
    private Integer minCharge;

    private String openAt;

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
     * 外卖结束时间
     */
    private String deliveryCloseAt;

    /**
     * 外卖开始时间
     */
    private String deliveryOpenAt;

    private LocalDateTime lastOperatedAt;

    /**
     * 外卖启停最后操作时间
     */
    private LocalDateTime takeawayLastOperateAt;

    private Boolean supportTakeaway;

    /**
     * 是否支持美团外卖
     */
    private Boolean supportMtTakeaway;

    /**
     * 是否支持顺丰外卖
     */
    private Boolean supportSfTakeaway;

    /**
     * 外卖状态0关1开
     */
    private Integer takeawayStatus;

    /**
     * 关闭订单类型：0 全部开启；1 禁用自取单；2 禁用预约单；3:全部禁用
     */
    private Boolean disableOrderType;

    /**
     * 小程序码
     */
    private String sceneCode;

    /**
     * 小程序二维码
     */
    private String qrcode;

    /**
     * 门店提示语
     */
    private String tips;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;


}
