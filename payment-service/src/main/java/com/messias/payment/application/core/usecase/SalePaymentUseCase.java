package com.messias.payment.application.core.usecase;

import com.messias.payment.application.core.domain.Payment;
import com.messias.payment.application.core.domain.Sale;
import com.messias.payment.application.core.domain.User;
import com.messias.payment.application.core.domain.enums.SaleEvent;
import com.messias.payment.application.ports.in.FindUserByIdInputPort;
import com.messias.payment.application.ports.in.SalePaymentInputPort;
import com.messias.payment.application.ports.out.SavePaymentOutputPort;
import com.messias.payment.application.ports.out.SendValidatedPaymentOutputPort;
import com.messias.payment.application.ports.out.UpdateUserOutputPort;
import jakarta.validation.Payload;

public class SalePaymentUseCase implements SalePaymentInputPort {

    private final FindUserByIdInputPort findUserByIdInputPort;
    private final UpdateUserOutputPort updateUserOutputPort;

    private final SavePaymentOutputPort savePaymentOutputPort;

    private final SendValidatedPaymentOutputPort sendValidatedPaymentOutputPort;

    public SalePaymentUseCase(FindUserByIdInputPort findUserByIdInputPort,
                              UpdateUserOutputPort updateUserOutputPort,
                              SavePaymentOutputPort savePaymentOutputPort,
                              SendValidatedPaymentOutputPort sendValidatedPaymentOutputPort) {
        this.findUserByIdInputPort = findUserByIdInputPort;
        this.updateUserOutputPort = updateUserOutputPort;
        this.savePaymentOutputPort = savePaymentOutputPort;
        this.sendValidatedPaymentOutputPort = sendValidatedPaymentOutputPort;
    }

    @Override
    public void payment(Sale sale) {
        User user = findUserByIdInputPort.find(sale.getUserId());
        if(user.getBalance().compareTo(sale.getValue()) < 0){
            throw new RuntimeException("Saldo insuficiente");
        }
        user.debitBalance(sale.getValue());
        updateUserOutputPort.update(user);
        savePaymentOutputPort.save(buildPayment(sale));
        sendValidatedPaymentOutputPort.send(sale, SaleEvent.VALIDATED_PAYMENT);
    }


    private Payment buildPayment(Sale sale){
        return new Payment(null, sale.getUserId(), sale.getId(), sale.getValue());
    }
}