package com.increff.pos.util;

import com.increff.pos.commons.ApiException;
import com.increff.pos.model.data.ProductData;
import com.increff.pos.model.form.ProductForm;
import com.increff.pos.pojo.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductUtil {

    public static Product convert(ProductForm productForm) {
        Product product = new Product();
        product.setBarcode(productForm.getBarcode());
        product.setClientId(productForm.getClientId());
        product.setName(productForm.getName());
        product.setMrp(productForm.getMrp());
        product.setImgUrl(productForm.getImgUrl());
        return product;
    }

    public static ProductData convert(Product product) {
        ProductData productData = new ProductData();
        productData.setId(product.getId());
        productData.setBarcode(product.getBarcode());
        productData.setClientId(product.getClientId());
        productData.setName(product.getName());
        productData.setMrp(product.getMrp());
        productData.setImgUrl(product.getImgUrl());
        return productData;
    }

    public static List<ProductData> convert(List<Product> pojoList) {
        List<ProductData> dataList = new ArrayList<>();
        for(Product product : pojoList) {
            ProductData productData = new ProductData();
            productData.setId(product.getId());
            productData.setBarcode(product.getBarcode());
            productData.setClientId(product.getClientId());
            productData.setName(product.getName());
            productData.setMrp(product.getMrp());
            productData.setImgUrl(product.getImgUrl());
            dataList.add(productData);
        }
        return dataList;
    }

    public static void ifExists(Product product) throws ApiException {
        if(!Objects.isNull(product)) {
            throw new ApiException("Client already exists");
        }
    }

    public static void ifNotExists(Product product) throws ApiException {
        if(Objects.isNull(product)) {
            throw new ApiException("Client doesn't exist");
        }
    }
}
