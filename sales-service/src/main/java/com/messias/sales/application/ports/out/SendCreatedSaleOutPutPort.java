package com.messias.sales.application.ports.out;

import com.messias.sales.application.core.domain.Sale;
import com.messias.sales.application.core.domain.enums.SaleEvent;

public interface SendCreatedSaleOutPutPort {

    void send(Sale sale, SaleEvent event);
}
