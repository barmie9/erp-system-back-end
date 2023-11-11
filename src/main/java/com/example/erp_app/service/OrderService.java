package com.example.erp_app.service;

import com.example.erp_app.model.Order;
import com.example.erp_app.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }
}
