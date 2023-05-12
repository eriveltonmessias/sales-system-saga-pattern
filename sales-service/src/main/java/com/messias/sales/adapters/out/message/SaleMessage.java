package com.messias.sales.adapters.out.message;

import com.messias.sales.application.core.domain.Sale;
import com.messias.sales.application.core.domain.enums.SaleEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SaleMessage {

    private Sale sale;
    private SaleEvent saleEvent;
}
