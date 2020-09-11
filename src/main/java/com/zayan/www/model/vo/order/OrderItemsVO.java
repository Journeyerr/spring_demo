package com.zayan.www.model.vo.order;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderItemsVO {

    private Integer id;

    /**
     * 订单ID
     */
    private Integer orderId;

    /**
     * 商品ID
     */
    private Integer productId;

    /**
     * 名称
     */
    private String name;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 优惠价格
     */
    private BigDecimal discountPrice;

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

}
