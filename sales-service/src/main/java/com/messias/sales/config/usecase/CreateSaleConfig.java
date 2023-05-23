package com.messias.sales.config.usecase;

import com.messias.sales.adapters.out.SaveSaleAdapter;
import com.messias.sales.adapters.out.SendCreatedSaleAdapter;
import com.messias.sales.application.core.usecase.CreateSaleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateSaleConfig {

    @Bean
    public CreateSaleUseCase createSaleUseCase(SaveSaleAdapter saveSaleAdapter,
                                               SendCreatedSaleAdapter sendCreatedSaleAdapter){

        return new CreateSaleUseCase(saveSaleAdapter, sendCreatedSaleAdapter);
    }
}
