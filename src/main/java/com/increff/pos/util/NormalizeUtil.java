package com.increff.pos.util;

import com.increff.pos.model.form.ClientForm;

public class NormalizeUtil {
    public static void normalize(ClientForm clientForm) {
        clientForm.setClientName(clientForm.getClientName().trim().toLowerCase());
    }
}
