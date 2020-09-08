package com.zayan.www.service.impl;

import com.zayan.www.constant.enums.ErrorEnum;
import com.zayan.www.exception.order.OrderException;
import com.zayan.www.model.entity.*;
import com.zayan.www.model.form.api.CreateOrderForm;
import com.zayan.www.model.form.api.OrderItemsForm;
import com.zayan.www.repository.OrdersMapper;
import com.zayan.www.repository.ProductMapper;
import com.zayan.www.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zayan.www.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author AnYuan
 * @since 2020-09-08
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrdersMapper, Order> implements OrderService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private AddressService addressService;
    @Autowired
    private OrderAddressService orderAddressService;
    @Autowired
    private OrderItemsService orderItemsService;

    @Transactional( rollbackFor = Exception.class)
    @Override
    public Order storeOrder(CreateOrderForm form, Integer userId) {

        List<OrderItemsForm> itemsForms = form.getProducts();
        List<Integer> productIds = itemsForms.stream().map(OrderItemsForm::getId).collect(Collectors.toList());

        if (productIds.isEmpty()) {
            throw new OrderException(ErrorEnum.ORDER_PRODUCT_ERROR);
        }

        List<Product> products = productMapper.listProductByIds(productIds);
        Map<Integer, Product> idProductMap = products.stream().collect(Collectors.toMap(Product::getId, Function.identity()));

        BigDecimal totalFee = BigDecimal.ZERO;
        for (OrderItemsForm itemsForm : itemsForms ) {
            Product product = idProductMap.get(itemsForm.getId());
            if (!product.getPrice().equals(itemsForm.getPrice())) {
                throw new OrderException(ErrorEnum.ORDER_PRODUCT_PRICE_ERROR);
            }
            totalFee = totalFee.add(product.getPrice().multiply(BigDecimal.valueOf(itemsForm.getCount())));
        }

        if (!totalFee.equals(form.getTotalFee())) {
            throw new OrderException(ErrorEnum.ORDER_TOTAL_FEE_ERROR);
        }

        Order order = CreateOrderForm.coverOrder(form, userId);
        save(order);

        if (Objects.nonNull(form.getAddressId())) {
            Address address = addressService.getById(form.getAddressId());
            if (Objects.isNull(address) || !address.getUserId().equals(userId)) {
                throw new OrderException(ErrorEnum.ORDER_ADDRESS_ERROR);
            }
            OrderAddress orderAddress = CreateOrderForm.coverOrderAddress(order, address);
            orderAddressService.save(orderAddress);
        }

        for (OrderItemsForm itemsForm : itemsForms) {
            OrderItems orderItems = CreateOrderForm.coverOrderItems(order, itemsForm);
            orderItemsService.save(orderItems);
        }
        return order;
    }
}
