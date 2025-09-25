package com.increff.pos.dao;

import com.increff.pos.pojo.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;


@Repository
public class ClientDao extends AbstractDao<Client> {


    public Client findByName(String name) {
        TypedQuery<Client> query = getEntityManager()
                .createQuery("SELECT c FROM Client c WHERE c.clientName = :name", Client.class);
        query.setParameter("name", name);
        try {
            return query.getSingleResult();
        }
        catch (NoResultException e) {

            return null;
        }
    }

}