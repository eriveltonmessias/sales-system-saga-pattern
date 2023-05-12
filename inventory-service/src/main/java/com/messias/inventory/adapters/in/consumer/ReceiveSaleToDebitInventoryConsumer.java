package com.messias.inventory.adapters.in.consumer;

import com.messias.inventory.adapters.out.message.SaleMessage;
import com.messias.inventory.application.core.domain.enums.SaleEvent;
import com.messias.inventory.application.core.usecase.DebitInventoryUseCase;
import com.messias.inventory.application.ports.in.DebitInventoryInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToDebitInventoryConsumer {

    @Autowired
    private DebitInventoryInputPort debitInventoryInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "inventory-debit")
    public void receive(SaleMessage saleMessage){
        if(SaleEvent.CREATED_SALE.equals(saleMessage.getEvent())){
        log.info("Inicio da separação de mercadoria.");
        debitInventoryInputPort.debit(saleMessage.getSale());
        log.info("Inicio da separação de mercadoria.");
        }
    }
}
