package com.increff.pos.dao;

import com.increff.pos.pojo.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductDao extends AbstractDao<Product> {


    public Product findByBarcode(String barcode) {
        TypedQuery<Product> query = getEntityManager()
                .createQuery("SELECT p FROM Product p WHERE p.barcode = :barcode", Product.class);
        query.setParameter("barcode", barcode);
        try {
            return query.getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    public List<Product> findByClientId(Integer clientId) {
        TypedQuery<Product> query = getEntityManager()
                .createQuery("SELECT p FROM Product p WHERE p.clientId = :clientId", Product.class);
        query.setParameter("clientId", clientId);
        return query.getResultList();
    }

    public List<Product> findByName(String name) {
        TypedQuery<Product> query = getEntityManager()
                .createQuery("SELECT p FROM Product p WHERE p.name LIKE :name", Product.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    public List<Product> findByMrpBetween(Double minMrp, Double maxMrp) {
        TypedQuery<Product> query = getEntityManager()
                .createQuery("SELECT p FROM Product p WHERE p.mrp BETWEEN :minMrp AND :maxMrp", Product.class);
        query.setParameter("minMrp", minMrp);
        query.setParameter("maxMrp", maxMrp);
        return query.getResultList();
    }
}