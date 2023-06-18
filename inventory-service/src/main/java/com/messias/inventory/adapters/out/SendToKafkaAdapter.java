package com.messias.inventory.adapters.out;

import com.messias.inventory.adapters.out.message.SaleMessage;
import com.messias.inventory.application.core.domain.Sale;
import com.messias.inventory.application.core.domain.enums.SaleEvent;
import com.messias.inventory.application.ports.out.SendToKafkaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendToKafkaAdapter implements SendToKafkaOutputPort {

   @Autowired
   private KafkaTemplate<String, SaleMessage> kafkaTemplate;
    @Override
    public void send(Sale sale, SaleEvent saleEvent) {
        kafkaTemplate.send("tp-saga-sale", new SaleMessage(sale, saleEvent));
    }
}
