package com.messias.sales.application.ports.out;

import com.messias.sales.application.core.domain.Sale;

import java.util.Optional;

public interface FindSaleByIdOutputPort {

    Optional<Sale> find(Integer id);
}
