package com.increff.pos.dto;

import com.increff.pos.api.ClientApi;
import com.increff.pos.commons.ApiException;
import com.increff.pos.model.data.ClientData;
import com.increff.pos.model.form.ClientForm;
import com.increff.pos.pojo.Client;
import com.increff.pos.util.ConvertUtil;
import com.increff.pos.util.NormalizeUtil;
import com.increff.pos.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientDto {

    @Autowired
    ClientApi clientApi;

    @Autowired
    ConvertUtil convertUtil;

    public ClientData add(ClientForm clientForm) throws ApiException {
        NormalizeUtil.normalize(clientForm);
        ValidationUtil.validate(clientForm);
        Client clientPojo = convertUtil.convert(clientForm,Client.class);
        clientApi.add(clientPojo);
        return convertUtil.convert(clientPojo,ClientData.class);
    }

    public ClientData getById(Integer id) throws ApiException {
        Client clientPojo = clientApi.getById(id);
        return convertUtil.convert(clientPojo,ClientData.class);
    }

    public List<ClientData> getAll() {
        List<Client> list = clientApi.getAll();
        return convertUtil.convert(list,ClientData.class);
    }

    public ClientData update(Integer id, ClientForm clientForm) throws ApiException {
        NormalizeUtil.normalize(clientForm);
        ValidationUtil.validate(clientForm);
        Client clientPojo = convertUtil.convert(clientForm,Client.class);
        Client updatedPojo = clientApi.update(id, clientPojo);
        return convertUtil.convert(updatedPojo,ClientData.class);
    }

    public void delete(Integer id, ClientForm clientForm) throws ApiException {
        NormalizeUtil.normalize(clientForm);
        ValidationUtil.validate(clientForm);
        Client clientPojo = convertUtil.convert(clientForm,Client.class);
        clientApi.delete(id, clientPojo);
    }



}
