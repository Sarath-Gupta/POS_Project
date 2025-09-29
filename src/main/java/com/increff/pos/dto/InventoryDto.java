package com.increff.pos.dto;

import com.increff.pos.api.InventoryApi;
import com.increff.pos.commons.ApiException;
import com.increff.pos.model.data.InventoryData;
import com.increff.pos.model.form.InventoryForm;
import com.increff.pos.pojo.Inventory;
import com.increff.pos.util.InventoryUtil;
import com.increff.pos.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventoryDto {

    @Autowired
    private InventoryApi inventoryApi;

    public InventoryData add(InventoryForm form) throws ApiException {
        ValidationUtil.validate(form);
        Inventory inventory = InventoryUtil.convert(form);
        inventoryApi.add(inventory);
        return InventoryUtil.convert(inventory);
    }


    public InventoryData update(Integer id, InventoryForm form) throws ApiException {
        ValidationUtil.validate(form);
        Inventory inventory = InventoryUtil.convert(form);
        Inventory updatedInventory = inventoryApi.update(id, inventory);
        return InventoryUtil.convert(updatedInventory);
    }

    public InventoryData findById(Integer id) throws ApiException {
        Inventory inventory = inventoryApi.findById(id);
        return InventoryUtil.convert(inventory);
    }

    public List<InventoryData> getAll() {
        List<Inventory> inventoryList = inventoryApi.getAll();
        return InventoryUtil.convert(inventoryList);
    }
}
