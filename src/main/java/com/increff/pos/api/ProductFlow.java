package com.increff.pos.api;

import com.increff.pos.commons.ApiException;
import com.increff.pos.pojo.Client;
import com.increff.pos.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductFlow {

    @Autowired
    ClientApi clientApi;

    @Autowired
    ProductApi productApi;

    public void add(Product product) throws ApiException {
        Client clientPojo = clientApi.getById(product.getClientId());
        if(Objects.isNull(clientPojo)) {
            throw new ApiException("Client doesn't exist");
        }
        productApi.add(product);
    }
}
