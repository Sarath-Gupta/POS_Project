package com.increff.pos.util;

import com.increff.pos.commons.ApiException;
import com.increff.pos.model.data.ClientData;
import com.increff.pos.model.form.ClientForm;
import com.increff.pos.pojo.Client;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClientUtil {

    @Autowired
    private ModelMapper modelMapper;

    public static Client convert(ClientForm form) {
        Client pojo = new Client();
        pojo.setClientName(form.getClientName());
        return pojo;
    }

    public static ClientData convert(Client pojo) {
        ClientData data = new ClientData();
        data.setId(pojo.getId());
        data.setClientName(pojo.getClientName());
        return data;

    }

    public static List<ClientData> convert(List<Client> listClients) {
        List<ClientData> listData = new ArrayList<>();
        for(Client client : listClients) {
            ClientData data = new ClientData();
            data.setId(client.getId());
            data.setClientName(client.getClientName());
            listData.add(data);
        }
        return listData;
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
