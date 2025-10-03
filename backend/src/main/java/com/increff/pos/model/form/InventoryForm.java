package com.increff.pos.model.form;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Getter
@Setter

public class InventoryForm {
    @NotNull
    private Integer productId;

    @NotNull @Max(255)
    private Integer quantity;
}
