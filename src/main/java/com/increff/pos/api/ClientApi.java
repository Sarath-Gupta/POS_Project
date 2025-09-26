package com.increff.pos.api;

import com.increff.pos.dao.ClientDao;
import com.increff.pos.pojo.Client;
import com.increff.pos.commons.ApiException;
import com.increff.pos.util.ClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ClientApi {

    @Autowired
    private ClientDao clientDao;

    @Transactional
    public void add(Client client) throws ApiException {
        Client existingClient = clientDao.findByName(client.getClientName());
        ClientUtil.ifExists(existingClient);
        clientDao.add(client);
    }


    public Client getById(Integer id) throws ApiException {
        Client clientPojo = clientDao.findById(id);
        ClientUtil.ifNotExists(clientPojo);
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
        ClientUtil.ifNotExists(client);
        clientDao.delete(client);
    }

}