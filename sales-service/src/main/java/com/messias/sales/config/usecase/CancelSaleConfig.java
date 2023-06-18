package com.messias.sales.config.usecase;

import com.messias.sales.adapters.out.SaveSaleAdapter;
import com.messias.sales.application.core.usecase.CancelSaleUseCase;
import com.messias.sales.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class CancelSaleConfig {

    @Bean
    public CancelSaleUseCase cancelSaleUseCase(
            FindSaleByIdUseCase findSaleByIdUseCase,
            SaveSaleAdapter saveSaleAdapter){
        return  new CancelSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }
}
