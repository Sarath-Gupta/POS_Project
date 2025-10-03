package com.increff.pos.api;

import com.increff.pos.commons.ApiException;
import com.increff.pos.pojo.OrderItem;
import com.increff.pos.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class OrderItemFlow {

    @Autowired
    ProductApi productApi;

    @Autowired
    OrderItemApi orderItemApi;

    @Autowired
    OrderApi orderApi;

    @Transactional
    public void add(List<OrderItem> list) throws ApiException {
        Orders order = new Orders();
        orderApi.add(order);
        for(OrderItem orderItem : list) {
            Integer id = orderItem.getProductId();
            productApi.findById(id);
            orderItem.setOrderId(order.getId());
            orderItemApi.add(orderItem);
        }

    }
}
