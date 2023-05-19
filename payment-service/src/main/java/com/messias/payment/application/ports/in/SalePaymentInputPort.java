package com.messias.payment.application.ports.in;

import com.messias.payment.application.core.domain.Sale;

public interface SalePaymentInputPort {

     void payment(Sale sale);
}
