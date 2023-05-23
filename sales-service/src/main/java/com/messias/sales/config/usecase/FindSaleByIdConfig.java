package com.messias.sales.config.usecase;

import com.messias.sales.adapters.out.FindSaleByIdAdapter;
import com.messias.sales.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindSaleByIdConfig {

    @Bean
    public FindSaleByIdUseCase findSaleByIdUseCase(FindSaleByIdAdapter findSaleByIdAdapter){
        return new FindSaleByIdUseCase(findSaleByIdAdapter);
    }
}
