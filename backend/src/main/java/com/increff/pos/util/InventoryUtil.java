package com.increff.pos.util;

import com.increff.pos.commons.ApiException;
import com.increff.pos.model.data.InventoryData;
import com.increff.pos.model.form.InventoryForm;
import com.increff.pos.entity.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InventoryUtil {

    public static Inventory convert(InventoryForm form) {
        Inventory inventory = new Inventory();
        inventory.setProductId(form.getProductId());
        inventory.setQuantity(form.getQuantity());
        return inventory;
    }

    public static InventoryData convert(Inventory inventory) {
        InventoryData data = new InventoryData();
        data.setId(inventory.getId());
        data.setProductId(inventory.getProductId());
        data.setQuantity(inventory.getQuantity());
        return data;
    }

    public static List<InventoryData> convert(List<Inventory> pojoList) {
        List<InventoryData> dataList = new ArrayList<>();
        for (Inventory inventory : pojoList) {
            InventoryData data = new InventoryData();
            data.setId(inventory.getId());
            data.setProductId(inventory.getProductId());
            data.setQuantity(inventory.getQuantity());
            dataList.add(data);
        }
        return dataList;
    }

}
