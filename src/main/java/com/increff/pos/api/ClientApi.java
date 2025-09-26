package com.increff.pos.api;

import com.increff.pos.dao.ClientDao;
import com.increff.pos.pojo.Client;
import com.increff.pos.exception.ApiException;
import com.increff.pos.util.ClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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


    public Client getById(Integer id) {
        return clientDao.findById(id);
    }


    public List<Client> getAll() {
        return clientDao.findAll();
    }


    public void update(Integer id, Client client) throws ApiException {
        Client existingClient = getById(id);

        Client clientWithSameName = clientDao.findByName(client.getClientName());
        if (clientWithSameName != null && !Objects.equals(clientWithSameName.getId(), existingClient.getId())) {
            throw new ApiException("Client with name '" + client.getClientName() + "' already exists.");
        }

        existingClient.setClientName(client.getClientName().trim().toLowerCase());
        clientDao.add(existingClient);
    }

}