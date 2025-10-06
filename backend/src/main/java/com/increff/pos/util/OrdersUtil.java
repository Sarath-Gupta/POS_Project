package com.increff.pos.util;

import com.increff.pos.model.data.OrderData;
import com.increff.pos.entity.Orders;

import java.util.ArrayList;
import java.util.List;

public class OrdersUtil {

    public static List<OrderData> convert(List<Orders> listPojo) {
        List<OrderData> listData = new ArrayList<>();
        for(Orders order : listPojo) {
            OrderData orderData = new OrderData();
            orderData.setId(order.getId());
            listData.add(orderData);
        }
        return listData;
    }

    public static OrderData convert(Orders orderPojo) {
        OrderData orderData = new OrderData();
        orderData.setId(orderPojo.getId());
        return orderData;
    }
}
