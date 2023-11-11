package com.example.erp_app.dto;

import com.example.erp_app.model.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDtoMapper {

    private OrderDtoMapper(){};

    public static List<OrderDto> mapOrderDtos(List<Order> orders){
        return orders.stream()
                .map(OrderDtoMapper::mapToOrderDto)
                .collect(Collectors.toList());
    }

    public static OrderDto mapToOrderDto (Order order){
        return OrderDto.builder()
                .id(order.getId())
                .name(order.getName())
                .quantity(order.getQuantity())
                .createDate(order.getCreateDate().toString())
                .expectDays(order.getExpectDays())
                .realDays(order.getRealDays())
                .orderManager(order.getUser().getName() + " " + order.getUser().getSurname())
                .companyOrder(order.getCompanyOrder().getName())
                .build();

    }
}
