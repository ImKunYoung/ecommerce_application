package com.example.msuserservice.service;

import com.example.msuserservice.vo.ResponseOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-ordersservice") // Order-Service의 application name
public interface OrderServiceClient {

    @GetMapping("/ms-ordersservice/{userId}/orders") // 주문 확인을 위한 URI
    List<ResponseOrder> getOrders(@PathVariable String userId);


}
