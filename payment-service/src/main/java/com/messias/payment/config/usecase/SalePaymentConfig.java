package com.messias.payment.config.usecase;

import com.messias.payment.adapters.out.SavePaymentAdapter;
import com.messias.payment.adapters.out.SendToKafkaAdapter;
import com.messias.payment.adapters.out.UpdateUserAdapter;
import com.messias.payment.application.core.usecase.FindUserByIdUseCase;
import com.messias.payment.application.core.usecase.SalePaymentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalePaymentConfig {

    @Bean
    public SalePaymentUseCase salePaymentUseCase(FindUserByIdUseCase findUserByIdUseCase,
                                                 UpdateUserAdapter updateUserAdapter,
                                                 SavePaymentAdapter savePaymentAdapter,
                                                 SendToKafkaAdapter sendToKafkaAdapter){

        return  new SalePaymentUseCase(findUserByIdUseCase, updateUserAdapter, savePaymentAdapter, sendToKafkaAdapter);

    }
}
