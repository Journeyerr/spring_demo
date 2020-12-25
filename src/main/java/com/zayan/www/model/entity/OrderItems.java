package com.zayan.www.model.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单详情项
 * </p>
 *
 * @author AnYuan
 * @since 2020-09-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderItems implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单ID
     */
    private Integer orderId;

    /**
     * 门店ID
     */
    private Integer shopId;

    /**
     * 商品ID
     */
    private Integer productId;

    /**
     * 名称
     */
    private String name;

    /**
     * SKU ID
     */
    private Integer skuId;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 优惠价格
     */
    private BigDecimal discountPrice;

    /**
     * 打包费
     */
    private BigDecimal boxFee;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 总金额
     */
    private BigDecimal totalFee;

    /**
     * 实际数量
     */
    private String actualQuantity;

    /**
     * 商品快照
     */
    private String image;

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
    private LocalDateTime deletedAt;


}
