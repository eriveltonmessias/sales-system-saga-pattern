package com.messias.sales.adapters.in.controller.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class SaleRequest {

    @NotNull
    private Integer userId;
    @NotNull
    private Integer productId;
    @NotNull
    private Integer quantity;
    @NotNull
    private BigDecimal value;
}
