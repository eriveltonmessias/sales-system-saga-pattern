package com.messias.sales.application.ports.out;

import com.messias.sales.application.core.domain.Sale;

public interface SaveSaleOutPutPort {

    Sale save(Sale sale);
}
