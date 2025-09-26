package com.increff.pos.controller;

import com.increff.pos.dto.ClientDto;
import com.increff.pos.exception.ApiException;
import com.increff.pos.model.form.ClientForm;
import com.increff.pos.model.data.ClientData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientDto clientDto;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ClientData addClient(@RequestBody ClientForm clientForm) throws ApiException {
        return clientDto.add(clientForm);
    }
}
