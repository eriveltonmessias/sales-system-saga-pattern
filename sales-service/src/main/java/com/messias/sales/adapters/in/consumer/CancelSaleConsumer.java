package com.messias.sales.adapters.in.consumer;

import com.messias.sales.adapters.out.message.SaleMessage;
import com.messias.sales.application.core.domain.enums.SaleEvent;
import com.messias.sales.application.ports.in.CancelSaleInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CancelSaleConsumer {

    @Autowired
    private CancelSaleInputPort cancelSaleInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "sale-cancel")
    public void receive(SaleMessage saleMessage){

        if(SaleEvent.ROLLBACK_INVENTORY.equals(saleMessage.getSaleEvent())){
            log.info("Cancelando a venda");
            this.cancelSaleInputPort.cancel(saleMessage.getSale());
            log.info("Venda cancelada");
        }
    }

}
