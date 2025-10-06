package com.increff.pos.controller;

import com.increff.pos.dto.ClientDto;
import com.increff.pos.commons.ApiException;
import com.increff.pos.model.form.ClientForm;
import com.increff.pos.model.data.ClientData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientDto clientDto;

    @RequestMapping(method = RequestMethod.POST)
    public ClientData addClient(@RequestBody ClientForm clientForm) throws ApiException {
        return clientDto.add(clientForm);
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public List<ClientData> addFile(@RequestParam MultipartFile file) throws ApiException {
//        return clientDto.addFile(file);
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ClientData getClientById(@PathVariable(value = "id") Integer id) throws ApiException {
        return clientDto.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ClientData> getAll() throws ApiException {
        return clientDto.getAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ClientData updateClient(@PathVariable(value = "id") Integer id, @RequestBody ClientForm clientForm) throws ApiException {
        return clientDto.update(id, clientForm);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteClient(@PathVariable(value = "id") Integer id) throws ApiException {
        clientDto.delete(id);
    }
}
