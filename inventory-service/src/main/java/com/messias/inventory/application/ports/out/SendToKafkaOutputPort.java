package com.messias.inventory.application.ports.out;

import com.messias.inventory.application.core.domain.Sale;
import com.messias.inventory.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutputPort {

    void send(Sale sale, SaleEvent saleEvent);
}
