package com.increff.pos.model.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ProductForm {
    @NotNull
    @Size(max = 255)
    private String barcode;

    @NotNull
    @Max(255)
    private Integer clientId;

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Max(100000)
    private Double mrp;

    private String imgUrl;
}
