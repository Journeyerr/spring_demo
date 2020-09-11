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
 * 订单表
 * </p>
 *
 * @author AnYuan
 * @since 2020-09-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("orders")
public class Order implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号
     */
    private String no;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 门店ID
     */
    private Integer shopId;

    /**
     * 是否外卖
     */
    private Integer isTakeaway;

    /**
     * 用户下单经纬度
     */
    private String location;

    /**
     * 总金额
     */
    private BigDecimal totalFee;

    /**
     * 支付金额
     */
    private BigDecimal payment;

    /**
     * 打包费
     */
    private BigDecimal boxFee;

    /**
     * 配送费
     */
    private BigDecimal deliveryFee;

    /**
     * 优惠金额
     */
    private BigDecimal discountFee;

    /**
     * 微信代金券或立减优惠金额
     */
    private BigDecimal couponFee;

    /**
     * 状态
     */
    private String status;

    /**
     * 订单备注
     */
    private String remarks;

    /**
     * 预约送货时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String pickupTime;

    /**
     * 关闭时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime closedAt;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
      @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
      @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    /**
     * 删除时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deletedAt;


}
