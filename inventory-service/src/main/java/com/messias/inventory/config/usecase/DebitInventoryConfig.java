package com.messias.inventory.config.usecase;

import com.messias.inventory.adapters.out.SendUpdatedInventoryAdapter;
import com.messias.inventory.adapters.out.UpdateInventoryAdapter;
import com.messias.inventory.application.core.usecase.DebitInventoryUseCase;
import com.messias.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class DebitInventoryConfig {

    @Bean
    public DebitInventoryUseCase debitInventoryUseCase(
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
            UpdateInventoryAdapter updateInventoryAdapter,
            SendUpdatedInventoryAdapter sendUpdatedInventoryAdapter
    ){
        return new DebitInventoryUseCase(findInventoryByProductIdUseCase, updateInventoryAdapter, sendUpdatedInventoryAdapter);
    }
}
