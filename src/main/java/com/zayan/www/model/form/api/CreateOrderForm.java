package com.zayan.www.model.form.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zayan.www.model.entity.Address;
import com.zayan.www.model.entity.Order;
import com.zayan.www.model.entity.OrderAddress;
import com.zayan.www.util.StringUtil;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Data
public class CreateOrderForm {

    @JsonProperty("products")
    private List<OrderItemsForm> products;

    @JsonProperty("remark")
    private String remark;

    @JsonProperty("totalFee")
    @NotNull(message = "总金额不能为空")
    private BigDecimal totalFee;

    @JsonProperty("addressId")
    private Integer addressId;

    @JsonProperty("shopId")
    @NotNull(message = "下单门店不能为空")
    private Integer shopId;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("pickupTime")
    private String pickupTime;



    public static Order coverOrder(CreateOrderForm form, Integer userId) {
        Order order = new Order();
        order.setUserId(userId);
        order.setNo(StringUtil.no());
        order.setRemarks(form.getRemark());
        order.setPhone(form.getPhone());
        order.setShopId(form.getShopId());
        order.setPickupTime(form.getPickupTime());
        order.setTotalFee(form.getTotalFee());
        order.setPayment(form.getTotalFee());
        order.setIsTakeaway(Objects.isNull(form.getAddressId()) ? 0 : 1);
        return order;
    }

    public static OrderAddress coverOrderAddress(Order order, Address address) {
        OrderAddress orderAddress = new OrderAddress();
        orderAddress.setOrderId(order.getId());
        orderAddress.setUserId(order.getUserId());
        orderAddress.setShopId(order.getShopId());
        orderAddress.setName(address.getName());
        orderAddress.setPhone(address.getPhone());
        orderAddress.setAddressId(address.getId());
        orderAddress.setAddress(address.getAddress());
        return orderAddress;
    }
}
