package com.messias.sales.adapters.in.controller;

import com.messias.sales.adapters.in.controller.mapper.SaleRequestMapper;
import com.messias.sales.adapters.in.controller.request.SaleRequest;
import com.messias.sales.application.ports.in.CreateSaleInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {

    @Autowired
    private CreateSaleInputPort createSaleInputPort;
    @Autowired
    private SaleRequestMapper saleRequestMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSale(@Validated @RequestBody SaleRequest saleRequest){

        log.info("Criando a venda");

        this.createSaleInputPort.create(saleRequestMapper.toSale(saleRequest));
        log.info("Venda criada com sucesso");
    }
}
