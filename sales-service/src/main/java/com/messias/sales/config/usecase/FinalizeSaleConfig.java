package com.messias.sales.config.usecase;

import com.messias.sales.adapters.out.FindSaleByIdAdapter;
import com.messias.sales.adapters.out.SaveSaleAdapter;
import com.messias.sales.application.core.usecase.FinalizeSaleUseCase;
import com.messias.sales.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinalizeSaleConfig {

    @Bean
    public FinalizeSaleUseCase finalizeSaleUseCase(FindSaleByIdUseCase findSaleByIdUseCase, SaveSaleAdapter saveSaleAdapter){
        return new FinalizeSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }
}
