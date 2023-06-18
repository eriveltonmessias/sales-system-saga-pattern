package com.messias.sales.application.ports.in;

import com.messias.sales.application.core.domain.Sale;

public interface CancelSaleInputPort {

    public void cancel(Sale sale);
}
