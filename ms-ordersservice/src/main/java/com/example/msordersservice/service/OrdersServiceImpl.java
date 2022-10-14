package com.example.msordersservice.service;

import com.example.msordersservice.dto.OrderDto;
import com.example.msordersservice.entity.OrderEntity;
import com.example.msordersservice.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService{


    private final OrdersRepository repository;

    @Override
    public OrderDto createOrder(OrderDto orderDetails) {

        orderDetails.setOrderId(UUID.randomUUID().toString());
        orderDetails.setTotalPrice(orderDetails.getQty() * orderDetails.getUnitPrice());

        ModelMapper modelMapperer = new ModelMapper();
        modelMapperer.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        OrderEntity orderEntity = modelMapperer.map(orderDetails, OrderEntity.class);

        repository.save(orderEntity);

        return modelMapperer.map(orderEntity, OrderDto.class);
    }

    @Override
    public OrderDto getOrderByOrderId(String orderId) {

        OrderEntity orderEntity = repository.findByOrderId(orderId);

        return new ModelMapper().map(orderEntity, OrderDto.class);
    }

    @Override
    public Iterable<OrderEntity> getOrdersByUserId(String userId) {
        return repository.findByUserId(userId);
    }

}
