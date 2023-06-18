package com.messias.inventory.application.ports.in;

import com.messias.inventory.application.core.domain.Sale;

public interface CreditInventoryInputPort {

    public void credit(Sale sale);
}
