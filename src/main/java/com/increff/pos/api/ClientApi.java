package com.increff.pos.api;

import com.increff.pos.dao.ClientDao;
import com.increff.pos.pojo.Client;
import com.increff.pos.commons.ApiException;
import com.increff.pos.util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ClientApi {

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private ConvertUtil convertUtil;

    @Transactional
    public void add(Client client) throws ApiException {
        Client existingClient = clientDao.findByName(client.getClientName());
        convertUtil.ifExists(existingClient);
        clientDao.add(client);
    }


    public Client getById(Integer id) throws ApiException {
        Client clientPojo = clientDao.findById(id);
        convertUtil.ifNotExists(clientPojo);
        return clientPojo;
    }


    public List<Client> getAll() {
        return clientDao.findAll();
    }

    @Transactional
    public Client update(Integer id, Client client) throws ApiException {
        Client oldClient = getById(id);
        if(oldClient.getClientName().equals(client.getClientName())) {
            throw new ApiException("Client name already exists");
        }
        oldClient.setClientName(client.getClientName());
        clientDao.update(oldClient);
        return oldClient;
    }

    @Transactional
    public void delete(Integer id, Client client) throws ApiException {
        convertUtil.ifNotExists(client);
        clientDao.delete(client);
    }

}