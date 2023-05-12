package com.messias.inventory.application.ports.in;

import com.messias.inventory.application.core.domain.Inventory;

public interface FindInventoryByProductIdInputPort {
    Inventory find(Integer productId);
}
