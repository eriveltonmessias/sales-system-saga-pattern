package com.messias.payment.application.ports.out;

import com.messias.payment.application.core.domain.Payment;

public interface SavePaymentOutputPort {

    void save(Payment payment);
}
