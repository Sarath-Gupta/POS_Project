package com.increff.pos.api;

import com.increff.pos.commons.ApiException;
import com.increff.pos.model.form.OrderItemForm;
import com.increff.pos.pojo.OrderItem;
import com.increff.pos.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class OrderItemFlow {

    @Autowired
    ProductApi productApi;

    @Autowired
    OrderItemApi orderItemApi;

    public void add(List<OrderItem> list) throws ApiException {
        for(OrderItem orderItem : list) {
            Integer id = orderItem.getProductId();
            productApi.findById(id);
            orderItemApi.add(orderItem);
        }

    }
}
