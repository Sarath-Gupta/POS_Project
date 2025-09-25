package com.increff.pos.dao;

import com.increff.pos.pojo.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public abstract class AbstractDao<T> {

    @PersistenceContext
    private EntityManager entityManager;

    private final Class<T> entityClass;

    public AbstractDao() {
        this.entityClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public T findById(Integer id) {
        return entityManager.find(entityClass,id);
    }

    public List<T> findAll() {
        String className = entityClass.getSimpleName();
        TypedQuery<T> query = entityManager.createQuery("SELECT e FROM " + className + " e", entityClass);
        return query.getResultList();
    }

    public Client insert(T entity) {
        entityManager.persist(entity);
        return null;
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}