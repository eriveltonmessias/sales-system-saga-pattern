package com.messias.sales.application.core.usecase;

import com.messias.sales.application.core.domain.Sale;
import com.messias.sales.application.core.domain.enums.SaleStatus;
import com.messias.sales.application.ports.in.CancelSaleInputPort;
import com.messias.sales.application.ports.in.FindSaleByIdInputPort;
import com.messias.sales.application.ports.out.SaveSaleOutPutPort;

public class CancelSaleUseCase implements CancelSaleInputPort {

    private final FindSaleByIdInputPort findSaleByIdInputPort;
    private final SaveSaleOutPutPort saveSaleOutPutPort;

    public CancelSaleUseCase(FindSaleByIdInputPort findSaleByIdInputPort,
                             SaveSaleOutPutPort saveSaleOutPutPort) {
        this.findSaleByIdInputPort = findSaleByIdInputPort;
        this.saveSaleOutPutPort = saveSaleOutPutPort;
    }

    @Override
    public void cancel(Sale sale) {
    Sale saleFound = this.findSaleByIdInputPort.find(sale.getId());
        saleFound.setStatus(SaleStatus.CANCELED);
    this.saveSaleOutPutPort.save(saleFound);

    }
}
