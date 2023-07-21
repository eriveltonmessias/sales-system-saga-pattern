package com.messias.inventory.adapters.out.message;

import com.messias.inventory.application.core.domain.Sale;
import com.messias.inventory.application.core.domain.enums.SaleEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleMessage {
    private Sale sale;
    private SaleEvent saleEvent;
}
