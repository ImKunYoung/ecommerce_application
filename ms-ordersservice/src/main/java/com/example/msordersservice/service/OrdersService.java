package com.example.msordersservice.service;

import com.example.msordersservice.dto.OrderDto;

public interface OrdersService {

    OrderDto createOrder(OrderDto orderDetails);

    OrderDto getOrderByOrderId(String orderId);

    Iterable<OrderDto> getOrdersByUserId(String userId);

}
