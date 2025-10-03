package com.increff.pos.model.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class OrderItemForm {
    @NotNull
    private Integer productId;

    @NotNull @Max(250)
    private Integer quantity;

    @Max(10000) @Min(1)
    private Double sellingPrice;
}
