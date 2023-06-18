package com.messias.inventory.application.core.usecase;

import com.messias.inventory.application.core.domain.Inventory;
import com.messias.inventory.application.core.domain.Sale;
import com.messias.inventory.application.core.domain.enums.SaleEvent;
import com.messias.inventory.application.ports.in.CreditInventoryInputPort;
import com.messias.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.messias.inventory.application.ports.out.SendToKafkaOutputPort;
import com.messias.inventory.application.ports.out.UpdateInventoryOutputPort;

public class CreditInventoryUseCase implements CreditInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    private final UpdateInventoryOutputPort updateInventoryOutputPort;

    private final SendToKafkaOutputPort sendToKafkaOutputPort;

    public CreditInventoryUseCase(FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
                                  UpdateInventoryOutputPort updateInventoryOutputPort,
                                  SendToKafkaOutputPort sendToKafkaOutputPort) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendToKafkaOutputPort = sendToKafkaOutputPort;
    }

    @Override
    public void credit(Sale sale) {

        Inventory inventory = this.findInventoryByProductIdInputPort.find(sale.getProductId());
        inventory.creditQuantity(sale.getQuantity());
        this.updateInventoryOutputPort.update(inventory);
        this.sendToKafkaOutputPort.send(sale, SaleEvent.ROLLBACK_INVENTORY);



    }
}
