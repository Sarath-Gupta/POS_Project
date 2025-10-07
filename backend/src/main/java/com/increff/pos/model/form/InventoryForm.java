package com.increff.pos.model.form;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter

public class InventoryForm {
    @NotNull(message = "Product ID cannot be empty")
    @Positive(message = "Product ID must be positive")
    private Integer productId;

    @NotNull(message = "Quantity cannot be empty")
    @Max(value = 255, message = "Quantity cannot exceed 255")
    private Integer quantity;
}
