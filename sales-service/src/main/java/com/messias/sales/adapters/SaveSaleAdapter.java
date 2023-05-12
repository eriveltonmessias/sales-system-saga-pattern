package com.messias.sales.adapters;

import com.messias.sales.adapters.out.repository.SaleRepository;
import com.messias.sales.adapters.out.repository.entity.SaleEntity;
import com.messias.sales.adapters.out.repository.mapper.SaleEntityMapper;
import com.messias.sales.application.core.domain.Sale;
import com.messias.sales.application.ports.out.SaveSaleOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveSaleAdapter implements SaveSaleOutPutPort {

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private SaleEntityMapper saleEntityMapper;

    @Override
    public Sale save(Sale sale) {
        SaleEntity saleEntityResponse =  saleRepository.save(saleEntityMapper.toSaleEntity(sale));
        return saleEntityMapper.ToSale(saleEntityResponse);
    }
}
