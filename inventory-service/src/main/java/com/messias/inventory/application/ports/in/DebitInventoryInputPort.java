package com.messias.inventory.application.ports.in;

import com.messias.inventory.application.core.domain.Sale;

public interface DebitInventoryInputPort {
    public void debit(Sale sale);
}
