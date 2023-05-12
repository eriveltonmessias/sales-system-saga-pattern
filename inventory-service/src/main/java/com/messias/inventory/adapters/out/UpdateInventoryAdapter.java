package com.messias.inventory.adapters.out;

import com.messias.inventory.adapters.out.repository.InventoryRepository;
import com.messias.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import com.messias.inventory.application.core.domain.Inventory;
import com.messias.inventory.application.ports.out.UpdateInventoryOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateInventoryAdapter implements UpdateInventoryOutputPort {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private InventoryEntityMapper inventoryEntityMapper;
    @Override
    public void update(Inventory inventory) {
        inventoryRepository.save(inventoryEntityMapper.toInventoryEntity(inventory));
    }
}
