package com.messias.inventory.config.usecase;

import com.messias.inventory.adapters.out.SendToKafkaAdapter;
import com.messias.inventory.adapters.out.UpdateInventoryAdapter;
import com.messias.inventory.application.core.usecase.CreditInventoryUseCase;
import com.messias.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditInventoryConfig {


    @Bean
    public CreditInventoryUseCase creditInventoryUseCase(
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
            UpdateInventoryAdapter updateInventoryAdapter,
            SendToKafkaAdapter sendToKafkaAdapter
    ){
        return new CreditInventoryUseCase(findInventoryByProductIdUseCase, updateInventoryAdapter, sendToKafkaAdapter);
    }
}
