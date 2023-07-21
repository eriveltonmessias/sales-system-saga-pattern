package com.messias.sales.adapters.in.controller.mapper;

import com.messias.sales.adapters.in.controller.request.SaleRequest;
import com.messias.sales.application.core.domain.Sale;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {

    Sale toSale(SaleRequest saleRequest);
}
