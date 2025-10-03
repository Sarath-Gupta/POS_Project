package com.increff.pos.api;

import com.increff.pos.commons.ApiException;
import com.increff.pos.dao.OrdersDao;
import com.increff.pos.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


@Service
public class OrderApi {

    @Autowired
    OrdersDao ordersDao;

    @Transactional
    public void add(Orders order) {
        ordersDao.add(order);
    }

    public List<Orders> getAll() {
        return ordersDao.findAll();
    }

    public Orders getById(Integer id) throws ApiException {
        Orders order = ordersDao.findById(id);
        if(Objects.isNull(order)) {
            throw new ApiException("Order ID doesn't exist");
        }
        return order;
    }
}
