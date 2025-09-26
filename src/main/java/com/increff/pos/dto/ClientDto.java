package com.increff.pos.dto;

import com.increff.pos.api.ClientApi;
import com.increff.pos.commons.ApiException;
import com.increff.pos.model.data.ClientData;
import com.increff.pos.model.form.ClientForm;
import com.increff.pos.pojo.Client;
import com.increff.pos.util.ClientUtil;
import com.increff.pos.util.NormalizeUtil;
import com.increff.pos.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public ClientData getById(Integer id) throws ApiException {
        Client clientPojo = clientApi.getById(id);
        return ClientUtil.convert(clientPojo);
    }

    public List<ClientData> getAll() {
        List<Client> list = clientApi.getAll();
        return ClientUtil.convert(list);
    }

    public ClientData update(Integer id, ClientForm clientForm) throws ApiException {
        NormalizeUtil.normalize(clientForm);
        ValidationUtil.validate(clientForm);
        Client clientPojo = ClientUtil.convert(clientForm);
        Client updatedPojo = clientApi.update(id, clientPojo);
        return ClientUtil.convert(updatedPojo);
    }

    public void delete(Integer id, ClientForm clientForm) throws ApiException {
        NormalizeUtil.normalize(clientForm);
        ValidationUtil.validate(clientForm);
        Client clientPojo = ClientUtil.convert(clientForm);
        clientApi.delete(id, clientPojo);
    }



}
