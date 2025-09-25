package com.increff.pos.dto;

import com.increff.pos.model.data.ClientData;
import com.increff.pos.model.form.ClientForm;
import com.increff.pos.pojo.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientDto {

    public static Client convertFormToPojo(ClientForm form) {
        Client client = new Client();
        client.setClientName(form.getClientName());
        return client;
    }

    public static ClientData convertPojoToData(Client pojo) {
        ClientData data = new ClientData();
        data.setId(pojo.getId());
        data.setClientName(pojo.getClientName());
        return data;
    }
}
