package com.messias.sales.adapters.out.repository.mapper;

import com.messias.sales.adapters.out.repository.entity.SaleEntity;
import com.messias.sales.application.core.domain.Sale;
import com.messias.sales.application.core.domain.enums.SaleStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface SaleEntityMapper {

    @Mapping(source = "status", target = "status", qualifiedByName = "setStatusId")
    SaleEntity toSaleEntity(Sale sale);

    @Named("setStatusId")
    default Integer setStatusId(SaleStatus saleStatus) {
        return saleStatus.getStatusId();
    }

    @Mapping(source="status", target = "status", qualifiedByName = "setStatus")
    Sale ToSale(SaleEntity saleEntity);

    @Named("setStatus")
    default SaleStatus setStatusId(Integer status) {
        return SaleStatus.toEnum(status);
    }
}
