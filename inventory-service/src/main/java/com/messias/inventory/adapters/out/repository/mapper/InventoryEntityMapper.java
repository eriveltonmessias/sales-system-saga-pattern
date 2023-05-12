package com.messias.inventory.adapters.out.repository.mapper;

import com.messias.inventory.adapters.out.repository.entity.InventoryEntity;
import com.messias.inventory.application.core.domain.Inventory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryEntityMapper {
    Inventory toInventory(InventoryEntity inventoryEntity);

    InventoryEntity toInventoryEntity(Inventory inventory);
}
