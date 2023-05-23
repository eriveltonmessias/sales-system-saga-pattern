package com.messias.sales.adapters.out;

import com.messias.sales.adapters.out.message.SaleMessage;
import com.messias.sales.application.core.domain.Sale;
import com.messias.sales.application.core.domain.enums.SaleEvent;
import com.messias.sales.application.ports.out.SendCreatedSaleOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCreatedSaleAdapter implements SendCreatedSaleOutPutPort {

    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTemplate;
    @Override
    public void send(Sale sale, SaleEvent event) {
        SaleMessage saleMessage = new  SaleMessage(sale, event);

        kafkaTemplate.send("tp-saga-sale", saleMessage);
    }
}
