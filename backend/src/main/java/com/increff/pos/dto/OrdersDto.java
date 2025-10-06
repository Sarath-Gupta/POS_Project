package com.increff.pos.dto;

import com.increff.pos.api.OrderApi;
import com.increff.pos.commons.ApiException;
import com.increff.pos.model.data.OrderData;
import com.increff.pos.entity.Orders;
import com.increff.pos.util.AbstractMapper;
import com.increff.pos.util.OrdersUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdersDto {

    @Autowired
    OrderApi orderApi;

    @Autowired
    AbstractMapper mapper;

    public List<OrderData> getAll() {
        List<Orders> listPojo = orderApi.getAll();
        return mapper.convert(listPojo, OrderData.class);
    }

    public OrderData getById(Integer id) throws ApiException {
        Orders orderPojo = orderApi.getById(id);
        return mapper.convert(orderPojo, OrderData.class);
    }
}
