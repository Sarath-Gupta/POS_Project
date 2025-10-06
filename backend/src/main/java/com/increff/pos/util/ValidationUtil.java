package com.increff.pos.util;

import com.increff.pos.commons.ApiException;
import com.increff.pos.model.form.ClientForm;
import com.increff.pos.model.form.InventoryForm;
import com.increff.pos.model.form.OrderItemForm;
import com.increff.pos.model.form.ProductForm;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class ValidationUtil {

    //TODO: use Validator Factory
    public static <T> void validate(
            T field,
            String fieldName,
            Predicate<T> emptyCheck,
            ToIntFunction<T> sizeFunction) throws ApiException {

        if (field == null || emptyCheck.test(field)) {
            throw new ApiException(fieldName + " is empty");
        }
        if (sizeFunction.applyAsInt(field) > 255) {
            throw new ApiException(fieldName + " is too long");
        }
    }

    public static void validate(ClientForm clientForm) throws ApiException {
        validate(clientForm.getClientName(), "Client Name", String::isEmpty,String::length);
    }

    public static void validate(ProductForm productForm) throws ApiException {
        validate(productForm.getBarcode(),"Barcode", String::isEmpty, String::length);
        validate(productForm.getName(),"Product Name", String::isEmpty, String::length);
        validate(
                productForm.getClientId(),
                "Client ID",
                id -> id == 0,
                id -> String.valueOf(id).length()
        );
        validate(productForm.getMrp(),
                "MRP",
                d -> d == null || d == 0.0 || Double.isNaN(d),
                d -> String.valueOf(d).length()
        );
        validate(productForm.getImgUrl(),"Image URL",String::isEmpty, String::length);

    }

    public static void validate(InventoryForm inventoryForm) throws ApiException {
        validate(
                inventoryForm.getProductId(),
                "Product ID",
                id -> id == null || id <= 0,
                id -> String.valueOf(id).length()
        );

        validate(
                inventoryForm.getQuantity(),
                "Quantity",
                q -> q == null || q <= 0,
                q -> String.valueOf(q).length()
        );
    }

    public static void validate(List<OrderItemForm> orderItemFormList) throws ApiException {
        for(OrderItemForm orderItemForm : orderItemFormList) {
            validate(
                    orderItemForm.getProductId(),
                    "Product ID",
                    id -> id == null || id <= 0,
                    id -> String.valueOf(id).length()
            );

            validate(
                    orderItemForm.getQuantity(),
                    "Quantity",
                    quantity -> quantity == null | quantity < 0,
                    quantity -> String.valueOf(quantity).length()
            );
            validate(
                    orderItemForm.getSellingPrice(),
                    "Selling Price",
                    sp -> sp == null || sp <= 0,
                    sp -> String.valueOf(sp).length()
            );
        }
    }

    public static void validate(OrderItemForm orderItemForm) throws ApiException{
        validate(
                orderItemForm.getProductId(),
                "Product ID",
                id -> id == null || id <= 0,
                id -> String.valueOf(id).length()
        );

        validate(
                orderItemForm.getQuantity(),
                "Quantity",
                quantity -> quantity == null | quantity < 0,
                quantity -> String.valueOf(quantity).length()
        );
        validate(
                orderItemForm.getSellingPrice(),
                "Selling Price",
                sp -> sp == null || sp <= 0,
                sp -> String.valueOf(sp).length()
        );

    }

    public static void ifSameName(String oldClient, String newClient) throws ApiException {
        if(oldClient.equals(newClient)) {
            throw new ApiException("Client with same name already exists");
        }
    }
}
