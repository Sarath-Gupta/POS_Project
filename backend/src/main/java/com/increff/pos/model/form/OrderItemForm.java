package com.increff.pos.model.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class OrderItemForm {
    @NotNull
    private Integer productId;

    @NotNull @Max(250) @Positive
    private Integer quantity;

    @Max(100000) @Positive
    private Double sellingPrice;
}
