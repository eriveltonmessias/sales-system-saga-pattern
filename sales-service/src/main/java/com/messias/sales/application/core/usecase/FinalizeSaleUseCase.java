package com.messias.sales.application.core.usecase;

import com.messias.sales.application.core.domain.Sale;
import com.messias.sales.application.core.domain.enums.SaleStatus;
import com.messias.sales.application.ports.in.FinalizeSaleInputPort;
import com.messias.sales.application.ports.in.FindSaleByIdInputPort;
import com.messias.sales.application.ports.out.SaveSaleOutPutPort;

public class FinalizeSaleUseCase implements FinalizeSaleInputPort {

    private final FindSaleByIdInputPort findSaleByIdInputPort;
    private final SaveSaleOutPutPort saveSaleOutPutPort;

    public FinalizeSaleUseCase(FindSaleByIdInputPort findSaleByIdInputPort, SaveSaleOutPutPort saveSaleOutPutPort) {
        this.findSaleByIdInputPort = findSaleByIdInputPort;
        this.saveSaleOutPutPort = saveSaleOutPutPort;
    }

    @Override
    public void finalize(Sale sale) {
        Sale saleFinalize = this.findSaleByIdInputPort.find(sale.getId());
        saleFinalize.setStatus(SaleStatus.FINALIZED);
        this.saveSaleOutPutPort.save(saleFinalize);
    }
}
