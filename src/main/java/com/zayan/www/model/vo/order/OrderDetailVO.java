package com.zayan.www.model.vo.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zayan.www.model.vo.address.AddressVO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDetailVO {

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
     * 门店名称
     */
    private String shopName;

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
     * 总金额
     */
    private BigDecimal totalFee;

    /**
     * 支付金额
     */
    private BigDecimal payment;

    /**
     * 实际总金额
     */
    private BigDecimal actualTotalFee;

    /**
     * 实际支付金额
     */
    private BigDecimal actualPayment;

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
    private LocalDateTime createdAt;


    private List<OrderItemsVO>  items;

    private AddressVO address;
}
