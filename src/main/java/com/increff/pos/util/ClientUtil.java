package com.increff.pos.util;

import com.increff.pos.exception.ApiException;
import com.increff.pos.model.data.ClientData;
import com.increff.pos.model.form.ClientForm;
import com.increff.pos.pojo.Client;

import java.util.Objects;

public class ClientUtil {
    public static Client convert(ClientForm form) {
        Client client = new Client();
        client.setClientName(form.getClientName());
        return client;
    }

    public static ClientData convert(Client pojo) {
        ClientData data = new ClientData();
        data.setId(pojo.getId());
        data.setClientName(pojo.getClientName());
        return data;
    }

    public static void ifExists(Client client) throws ApiException{
        if(!Objects.isNull(client)) {
            throw new ApiException("Client already exists");
        }
    }

    public static void ifNotExists(Client client) throws ApiException {
        if(Objects.isNull(client)) {
            throw new ApiException("Client doesn't exist");
        }
    }
}
