package com.messias.sales.application.ports.in;

import com.messias.sales.application.core.domain.Sale;

import java.util.Optional;

public interface FindSaleByIdInputPort {

    Sale find(Integer id);
}
