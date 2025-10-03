package com.increff.pos.api;

import com.increff.pos.commons.ApiException;
import com.increff.pos.dao.OrderItemDao;
import com.increff.pos.pojo.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class OrderItemApi {

    @Autowired
    OrderItemDao orderItemDao;

    @Transactional
    public void add(OrderItem orderItem) {
        orderItemDao.add(orderItem);
    }

    public List<OrderItem> getAll() {
        return orderItemDao.findAll();
    }

    public OrderItem getById(Integer id) throws ApiException {
        OrderItem orderItemPojo = orderItemDao.findById(id);
        if(Objects.isNull(orderItemPojo)) {
            throw new ApiException("OrderItem Id doesn't exist");
        }
        return orderItemPojo;
    }

    @Transactional
    public OrderItem update(Integer id, OrderItem orderItem) throws ApiException {
        OrderItem orderItemExisting = orderItemDao.findById(id);
        orderItemExisting.setQuantity(orderItem.getQuantity());
        orderItemExisting.setSellingPrice(orderItem.getSellingPrice());
        return orderItemExisting;
    }
}
