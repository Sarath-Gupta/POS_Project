package com.increff.pos.api;

import com.increff.pos.commons.ApiException;
import com.increff.pos.dao.InventoryDao;
import com.increff.pos.pojo.Inventory;
import com.increff.pos.util.InventoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class InventoryApi {

    @Autowired
    private InventoryDao inventoryDao;

    @Transactional
    public void add(Inventory inventory) throws ApiException {
        Inventory existing = inventoryDao.findByProductId(inventory.getProductId());
        InventoryUtil.ifExists(existing);
        inventoryDao.add(inventory);
    }

    public Inventory findById(Integer id) throws ApiException {
        Inventory inventory = inventoryDao.findById(id);
        InventoryUtil.ifNotExists(inventory);
        return inventory;
    }

    public Inventory findByProductId(Integer productId) throws ApiException {
        Inventory inventory = inventoryDao.findByProductId(productId);
        InventoryUtil.ifNotExists(inventory);
        return inventory;
    }

    public List<Inventory> getAll() {
        return inventoryDao.findAll();
    }

    @Transactional
    public Inventory update(Integer id, Inventory updatedInventory) throws ApiException {
        Inventory existing = inventoryDao.findById(id);
        InventoryUtil.ifNotExists(existing);
        existing.setQuantity(updatedInventory.getQuantity());
        inventoryDao.update(existing);
        return existing;
    }
}
