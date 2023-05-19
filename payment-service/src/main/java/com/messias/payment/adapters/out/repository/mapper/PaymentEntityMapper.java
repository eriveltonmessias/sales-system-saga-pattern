package com.messias.payment.adapters.out.repository.mapper;

import com.messias.payment.adapters.out.repository.entity.PaymentEntity;
import com.messias.payment.application.core.domain.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentEntityMapper {

    PaymentEntity toPaymentEntity(Payment payment);
}
