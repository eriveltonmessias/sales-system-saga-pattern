package com.messias.sales.application.core.usecase;

import com.messias.sales.application.core.domain.Sale;
import com.messias.sales.application.core.domain.enums.SaleEvent;
import com.messias.sales.application.core.domain.enums.SaleStatus;
import com.messias.sales.application.ports.in.CreateSaleInputPort;
import com.messias.sales.application.ports.out.SaveSaleOutPutPort;
import com.messias.sales.application.ports.out.SendCreatedSaleOutPutPort;

public class CreateSaleUseCase implements CreateSaleInputPort {

    private final SaveSaleOutPutPort saveSaleOutPutPort;
    private final SendCreatedSaleOutPutPort sendCreatedSaleOutPutPort;

    public CreateSaleUseCase(SaveSaleOutPutPort saveSaleOutPutPort,
                             SendCreatedSaleOutPutPort sendCreatedSaleOutPutPort) {
        this.saveSaleOutPutPort = saveSaleOutPutPort;
        this.sendCreatedSaleOutPutPort = sendCreatedSaleOutPutPort;
    }

    @Override
    public void create(Sale sale) {
        sale.setStatus(SaleStatus.PENDING);
        Sale saleResponse = saveSaleOutPutPort.save(sale);
        sendCreatedSaleOutPutPort.send(saleResponse, SaleEvent.CREATED_SALE);
    }
}
