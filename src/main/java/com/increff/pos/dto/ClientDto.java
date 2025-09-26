package com.increff.pos.dto;

import com.increff.pos.api.ClientApi;
import com.increff.pos.exception.ApiException;
import com.increff.pos.model.data.ClientData;
import com.increff.pos.model.form.ClientForm;
import com.increff.pos.pojo.Client;
import com.increff.pos.util.ClientUtil;
import com.increff.pos.util.NormalizeUtil;
import com.increff.pos.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientDto {

    @Autowired
    ClientApi clientApi;

    public ClientData add(ClientForm clientForm) throws ApiException {
        NormalizeUtil.normalize(clientForm);
        ValidationUtil.validate(clientForm);
        Client clientPojo = ClientUtil.convert(clientForm);
        clientApi.add(clientPojo);
        return ClientUtil.convert(clientPojo);
    }

}
