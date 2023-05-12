package com.messias.inventory.application.core.usecase;

import com.messias.inventory.application.core.domain.Inventory;
import com.messias.inventory.application.core.domain.Sale;
import com.messias.inventory.application.core.domain.enums.SaleEvent;
import com.messias.inventory.application.ports.in.DebitInventoryInputPort;
import com.messias.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.messias.inventory.application.ports.out.FindInventoryByProductIdOutputPort;
import com.messias.inventory.application.ports.out.SendUpdatedInventoryOutputPort;
import com.messias.inventory.application.ports.out.UpdateInventoryOutputPort;

import java.util.Optional;

public class DebitInventoryUseCase implements DebitInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    private final UpdateInventoryOutputPort updateInventoryOutputPort;

    private final SendUpdatedInventoryOutputPort sendUpdatedInventoryOutputPort;

    public  DebitInventoryUseCase(FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
                                  UpdateInventoryOutputPort updateInventoryOutputPort,
                                  SendUpdatedInventoryOutputPort sendUpdatedInventoryOutputPort){
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendUpdatedInventoryOutputPort = sendUpdatedInventoryOutputPort;
    }

    @Override
    public void debit(Sale sale) {
        Inventory inventory = this.findInventoryByProductIdInputPort.find(sale.getProductId());

        if(inventory.getQuantity() < sale.getQuantity()){
            throw  new RuntimeException("Estoque insuficiente");
        }

        inventory.debitQuantity(sale.getQuantity());
        this.updateInventoryOutputPort.update(inventory);
        this.sendUpdatedInventoryOutputPort.send(sale, SaleEvent.UPDATED_INVENTORY);

    }
}
