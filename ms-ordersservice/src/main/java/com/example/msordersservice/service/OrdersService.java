package com.example.msordersservice.service;

import com.example.msordersservice.dto.OrderDto;
import com.example.msordersservice.entity.OrderEntity;

public interface OrdersService {

    OrderDto createOrder(OrderDto orderDetails);

    OrderDto getOrderByOrderId(String orderId);

    Iterable<OrderEntity> getOrdersByUserId(String userId);

}
