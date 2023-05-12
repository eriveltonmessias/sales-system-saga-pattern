package com.messias.sales.application.ports.in;

import com.messias.sales.application.core.domain.Sale;

public interface CreateSaleInputPort {

     void create(Sale sale);
}
