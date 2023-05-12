package com.messias.inventory.application.ports.out;

import com.messias.inventory.application.core.domain.Inventory;

public interface UpdateInventoryOutputPort {

    void update(Inventory inventory);
}
