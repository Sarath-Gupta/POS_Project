package com.increff.pos.util;

import com.increff.pos.exception.ApiException;
import com.increff.pos.model.form.ClientForm;
import io.swagger.annotations.Api;

public class ValidationUtil {
    private static void validate(String field, String fieldName) throws ApiException {
        if(field.isEmpty()) throw new ApiException(fieldName + " doesn't exist");
        if(field.length() > 255) throw new ApiException(fieldName + " is too long");
    }

    public static void validate(ClientForm clientForm) throws ApiException{
        validate(clientForm.getClientName(),"Client Name");
    }
}
