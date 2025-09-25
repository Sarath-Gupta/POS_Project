package com.increff.pos.controller;

import com.increff.pos.api.ClientApi;
import com.increff.pos.dto.ClientDto;
import com.increff.pos.exception.ApiException;
import com.increff.pos.model.form.ClientForm;
import com.increff.pos.model.data.ClientData;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientApi clientService;


    @PostMapping("/add")
    public ClientData addClient(@RequestBody @Valid ClientForm form) {
        var client = ClientDto.convertFormToPojo(form);
        try {
            clientService.add(client);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
        return ClientDto.convertPojoToData(client);
    }
}
