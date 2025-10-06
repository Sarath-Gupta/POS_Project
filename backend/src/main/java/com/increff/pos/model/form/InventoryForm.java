package com.increff.pos.model.form;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter

public class InventoryForm {
    @NotNull @Positive
    private Integer productId;

    @NotNull @Max(255)
    private Integer quantity;
}
