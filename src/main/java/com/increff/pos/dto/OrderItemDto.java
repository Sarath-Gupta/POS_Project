package com.increff.pos.dto;

import com.increff.pos.api.OrderItemApi;
import com.increff.pos.api.OrderItemFlow;
import com.increff.pos.commons.ApiException;
import com.increff.pos.model.data.OrderItemData;
import com.increff.pos.model.form.OrderItemForm;
import com.increff.pos.pojo.OrderItem;
import com.increff.pos.util.NormalizeUtil;
import com.increff.pos.util.OrderItemUtil;
import com.increff.pos.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderItemDto {

    @Autowired
    OrderItemApi orderItemApi;

    @Autowired
    OrderItemFlow orderItemFlow;

    public List<OrderItemData> add(List<OrderItemForm> listForm) throws ApiException {
        ValidationUtil.validate(listForm);
        List<OrderItem> listPojo = OrderItemUtil.convertToPojo(listForm);
        orderItemFlow.add(listPojo);
        return OrderItemUtil.convertToData(listPojo);
    }
}
