package com.increff.pos.dto;

import com.increff.pos.api.ProductApi;
import com.increff.pos.api.ProductFlow;
import com.increff.pos.commons.ApiException;
import com.increff.pos.model.data.ProductData;
import com.increff.pos.model.form.ProductForm;
import com.increff.pos.pojo.Product;
import com.increff.pos.util.NormalizeUtil;
import com.increff.pos.util.ProductUtil;
import com.increff.pos.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDto {

    @Autowired
    ProductApi productApi;

    @Autowired
    ProductFlow productFlow;

    public ProductData add(ProductForm productForm) throws ApiException {
        NormalizeUtil.normalize(productForm);
        ValidationUtil.validate(productForm);
        Product pojo = ProductUtil.convert(productForm);
        productFlow.add(pojo);
        return ProductUtil.convert(pojo);
    }

    public ProductData findById(Integer id) throws ApiException {
        Product productPojo = productApi.findById(id);
        return ProductUtil.convert(productPojo);
    }

    public List<ProductData> getAll() {
        List<Product> productList = productApi.getAll();
        return ProductUtil.convert(productList);
    }

    public ProductData update(Integer id, ProductForm productForm) throws ApiException {
        NormalizeUtil.normalize(productForm);
        ValidationUtil.validate(productForm);
        Product pojo = ProductUtil.convert(productForm);
        productApi.update(id,pojo);
        return ProductUtil.convert(pojo);
    }
}
