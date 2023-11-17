package com.example.erp_app.service;

import com.example.erp_app.controller.request.EditOrderRequest;
import com.example.erp_app.dto.AddOrderRequest;
import com.example.erp_app.model.CompanyOrder;
import com.example.erp_app.model.Order;
import com.example.erp_app.model.User;
import com.example.erp_app.repository.CompanyOrderRepository;
import com.example.erp_app.repository.OrderRepository;
import com.example.erp_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final CompanyOrderRepository companyOrderRepository;

    public List<Order> getOrders(){

        return orderRepository.findAllByOrderByIdDesc().orElseThrow();
    }

    public String addOrder(AddOrderRequest addOrderRequest){
        User user = userRepository.findById(addOrderRequest.getOrderManagerId()).orElseThrow();
        CompanyOrder companyOrder = companyOrderRepository.findById(addOrderRequest.getCompanyOrderId()).orElseThrow();

        Order order = new Order();

        order.setName(addOrderRequest.getName());
        order.setQuantity(addOrderRequest.getQuantity());
        order.setCreateDate(addOrderRequest.getCreateDate());
        order.setExpectDate(addOrderRequest.getExpectDate());
        order.setRealDate(addOrderRequest.getRealDate());
        order.setCompanyOrder(companyOrder);
        order.setOrderManager(user);

        orderRepository.save(order);
        return  "OK - Do poprawy addOrder()";
    }

    public String editOrder(EditOrderRequest editOrderRequest) {
        Order order = orderRepository.findById(editOrderRequest.getId()).orElse(null);
        CompanyOrder companyOrder = companyOrderRepository.findById(editOrderRequest.getCompanyOrderId()).orElse(null);

        if(order == null) return "ORDER NOT FOUND BY ID: " + editOrderRequest.getId().toString();
        if(companyOrder == null) return "COMPANY NOT FOUND BY ID: " + editOrderRequest.getCompanyOrderId().toString();

        order.setName(editOrderRequest.getName());
        order.setQuantity(editOrderRequest.getQuantity());
        order.setCompanyOrder(companyOrder);
        order.setExpectDate(editOrderRequest.getExpectDate());

        orderRepository.save(order);
        return "OK";
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElseThrow();
    }
}
