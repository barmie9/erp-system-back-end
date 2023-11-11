package com.example.erp_app.controller;

import com.example.erp_app.dto.OrderDto;
import com.example.erp_app.dto.OrderDtoMapper;
import com.example.erp_app.model.Order;
import com.example.erp_app.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @CrossOrigin
    @RequestMapping( value = "/orders" , method = RequestMethod.GET)
    public ResponseEntity<List<OrderDto>> getOrders(){
        List<Order> orders = orderService.getOrders();
        return ResponseEntity.status(HttpStatus.OK).body(OrderDtoMapper.mapOrderDtos(orders));
    }

}
