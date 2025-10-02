package com.increff.pos.model.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemForm {
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private Double sellingPrice;
}
