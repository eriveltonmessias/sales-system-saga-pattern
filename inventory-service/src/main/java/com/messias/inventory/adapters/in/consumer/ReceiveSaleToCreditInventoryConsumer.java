package com.messias.inventory.adapters.in.consumer;

import com.messias.inventory.adapters.out.message.SaleMessage;
import com.messias.inventory.application.core.domain.enums.SaleEvent;
import com.messias.inventory.application.ports.in.CreditInventoryInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReceiveSaleToCreditInventoryConsumer {
    @Autowired
    private CreditInventoryInputPort creditInventoryInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "inventory-credit")
    public void receive(SaleMessage saleMessage){

        if(SaleEvent.FAILED_PAYMENT.equals(saleMessage.getEvent())){
            log.info("Iniciando a devolução do produto");
            this.creditInventoryInputPort.credit(saleMessage.getSale());
            log.info("Produto devolvido");
        }
    }
}
