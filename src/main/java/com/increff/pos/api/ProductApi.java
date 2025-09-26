package com.increff.pos.api;


import com.increff.pos.dao.ProductDao;
import com.increff.pos.exception.ApiException;
import com.increff.pos.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductApi {

    @Autowired
    ProductDao productDao;

    @Transactional
    public void add(Product product) throws ApiException {
        Product exsistingProduct = productDao.findByName(product.getName());
        if(exsistingProduct != null) {
            throw new ApiException("Product with the same name already exists");
        }

        product.setName(product.getName().trim().toLowerCase());
        productDao.add(product);
    }





}
