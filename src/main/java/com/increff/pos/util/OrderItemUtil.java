package com.increff.pos.util;

import com.increff.pos.model.data.OrderItemData;
import com.increff.pos.model.form.OrderItemForm;
import com.increff.pos.pojo.OrderItem;
import java.util.ArrayList;
import java.util.List;

public class OrderItemUtil {

    public static List<OrderItem> convertToPojo(List<OrderItemForm> orderItemFormList) {
        List<OrderItem> orderItemList = new ArrayList<>();
        for(OrderItemForm orderItemForm : orderItemFormList) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(orderItemForm.getOrderId());
            orderItem.setProductId(orderItemForm.getProductId());
            orderItem.setQuantity(orderItemForm.getQuantity());
            orderItem.setSellingPrice(orderItemForm.getSellingPrice());
            orderItemList.add(orderItem);
        }
        return orderItemList;
    }

    public static List<OrderItemData> convertToData(List<OrderItem> orderItemList) {
        List<OrderItemData> listData = new ArrayList<>();
        for (OrderItem orderItem : orderItemList) {
            OrderItemData orderItemData = new OrderItemData();
            orderItemData.setId(orderItem.getId());
            orderItemData.setOrderId(orderItem.getOrderId());
            orderItemData.setProductId(orderItem.getProductId());
            orderItemData.setQuantity(orderItem.getQuantity());
            orderItemData.setSellingPrice(orderItem.getSellingPrice());
            listData.add(orderItemData);
        }
        return listData;
    }
}
