package com.messias.sales.adapters.out;

import com.messias.sales.adapters.out.repository.SaleRepository;
import com.messias.sales.adapters.out.repository.entity.SaleEntity;
import com.messias.sales.adapters.out.repository.mapper.SaleEntityMapper;
import com.messias.sales.application.core.domain.Sale;
import com.messias.sales.application.ports.out.FindSaleByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindSaleByIdAdapter implements FindSaleByIdOutputPort {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleEntityMapper saleEntityMapper;

    @Override
    public Optional<Sale> find(Integer id) {
        Optional<SaleEntity> saleEntity = saleRepository.findById(id);
        return saleEntity.map(saleEntityMapper::ToSale);
    }
}
