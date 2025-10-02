package com.increff.pos.controller;

import java.util.List;

import com.increff.pos.commons.ApiException;
import com.increff.pos.dto.OrderItemDto;
import com.increff.pos.model.data.OrderItemData;
import com.increff.pos.model.form.OrderItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderItems")
public class OrderItemController {

    @Autowired
    OrderItemDto orderItemDto;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public List<OrderItemData> addOrderItems(@RequestBody List<OrderItemForm> listForm) throws ApiException {
        return orderItemDto.add(listForm);
    }
}
