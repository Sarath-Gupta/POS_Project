package com.increff.pos.dao;

import com.increff.pos.pojo.Inventory;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;


@Repository
public class InventoryDao extends AbstractDao<Inventory> {

    public Inventory findByProductId(Integer productId) {
        TypedQuery<Inventory> query = getEntityManager()
                .createQuery("SELECT i FROM Inventory i WHERE i.productId = :productId", Inventory.class);
        query.setParameter("productId", productId);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Inventory> findByQuantityBetween(Integer min, Integer max) {
        TypedQuery<Inventory> query = getEntityManager()
                .createQuery("SELECT i FROM Inventory i WHERE i.quantity BETWEEN :min AND :max", Inventory.class);
        query.setParameter("min", min);
        query.setParameter("max", max);
        return query.getResultList();
    }

    public List<Inventory> findByDateBetween(LocalDate startDate, LocalDate endDate) {
        TypedQuery<Inventory> query = getEntityManager()
                .createQuery("SELECT i FROM Inventory i WHERE i.dateTime BETWEEN :startDate AND :endDate", Inventory.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }

}
