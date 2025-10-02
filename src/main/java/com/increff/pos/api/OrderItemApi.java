package com.increff.pos.api;

import com.increff.pos.dao.OrderItemDao;
import com.increff.pos.pojo.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderItemApi {

    @Autowired
    OrderItemDao orderItemDao;

    public void add(OrderItem orderItem) {
        orderItemDao.add(orderItem);
    }
}
