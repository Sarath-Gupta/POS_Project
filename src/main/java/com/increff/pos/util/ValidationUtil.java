package com.increff.pos.util;

import com.increff.pos.commons.ApiException;
import com.increff.pos.model.form.ClientForm;

public class ValidationUtil {
    private static void validate(String field, String fieldName) throws ApiException {
        if(field.isEmpty()) throw new ApiException(fieldName + " doesn't exist");
        if(field.length() > 255) throw new ApiException(fieldName + " is too long");
    }

    public static void validate(ClientForm clientForm) throws ApiException{
        validate(clientForm.getClientName(),"Client Name");
    }

    public static void ifSameName(String oldClient, String newClient) throws ApiException {
        if(oldClient.equals(newClient)) {
            throw new ApiException("Client with same name already exists");
        }
    }
}
