package com.messias.inventory.adapters.out;

import com.messias.inventory.adapters.out.repository.InventoryRepository;
import com.messias.inventory.adapters.out.repository.entity.InventoryEntity;
import com.messias.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import com.messias.inventory.application.core.domain.Inventory;
import com.messias.inventory.application.ports.out.FindInventoryByProductIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindInventoryProductIdAdapter implements FindInventoryByProductIdOutputPort {

    private final InventoryRepository inventoryRepository;
    private final InventoryEntityMapper inventoryEntityMapper;

    @Autowired
    public FindInventoryProductIdAdapter(InventoryRepository inventoryRepository,
                                         InventoryEntityMapper inventoryEntityMapper){
        this.inventoryRepository = inventoryRepository;
        this.inventoryEntityMapper = inventoryEntityMapper;
    }
    @Override
    public Optional<Inventory> find(Integer productId) {
        Optional<InventoryEntity> inventoryEntitys =  this.inventoryRepository.findByProductId(productId);
        return inventoryEntitys.map(entity -> inventoryEntityMapper.toInventory(entity));
    }
}
