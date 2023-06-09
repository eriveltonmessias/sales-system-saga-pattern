package com.messias.inventory.application.core.usecase;

import com.messias.inventory.application.core.domain.Inventory;
import com.messias.inventory.application.core.domain.Sale;
import com.messias.inventory.application.core.domain.enums.SaleEvent;
import com.messias.inventory.application.ports.in.DebitInventoryInputPort;
import com.messias.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.messias.inventory.application.ports.out.SendToKafkaOutputPort;
import com.messias.inventory.application.ports.out.UpdateInventoryOutputPort;

public class DebitInventoryUseCase implements DebitInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    private final UpdateInventoryOutputPort updateInventoryOutputPort;

    private final SendToKafkaOutputPort sendToKafkaOutputPort;

    public  DebitInventoryUseCase(FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
                                  UpdateInventoryOutputPort updateInventoryOutputPort,
                                  SendToKafkaOutputPort sendToKafkaOutputPort){
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendToKafkaOutputPort = sendToKafkaOutputPort;
    }

    @Override
    public void debit(Sale sale) {

      try{
        Inventory inventory = this.findInventoryByProductIdInputPort.find(sale.getProductId());
        if(inventory.getQuantity() < sale.getQuantity()){
            throw  new RuntimeException("Estoque insuficiente");
        }

        inventory.debitQuantity(sale.getQuantity());
        this.updateInventoryOutputPort.update(inventory);
        this.sendToKafkaOutputPort.send(sale, SaleEvent.UPDATED_INVENTORY);
    }catch (Exception e){
          sendToKafkaOutputPort.send(sale, SaleEvent.ROLLBACK_INVENTORY);
      }
    }
}
