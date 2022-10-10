package com.example.msordersservice.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RequestOrder {

    @NotNull(message = "Product Id cannot be null")
    @Size(min = 1, message = "Product Id cannot be empty")
    private String productId;

    @NotNull(message = "Qty cannot be null")
    @Size(min = 1, message = "Qty cannot be empty")
    private Integer qty;

    @NotNull(message = "Unit Price cannot be null")
    @Size(min = 1, message = "Unit Price cannot be empty")
    private Integer unitPrice;

}
