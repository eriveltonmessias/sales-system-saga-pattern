package com.messias.payment.application.ports.out;

import com.messias.payment.application.core.domain.Sale;
import com.messias.payment.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutputPort {

    void send(Sale sale, SaleEvent saleEvent);
}
