package com.messias.inventory.config.usecase;

import com.messias.inventory.adapters.out.FindInventoryProductIdAdapter;
import com.messias.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class FindInventoryByProductIdConfig {
    @Bean
    public FindInventoryByProductIdUseCase findInventoryByProductIdUseCase(FindInventoryProductIdAdapter findInventoryProductIdAdapter){
        return  new FindInventoryByProductIdUseCase(findInventoryProductIdAdapter);
    }
}
