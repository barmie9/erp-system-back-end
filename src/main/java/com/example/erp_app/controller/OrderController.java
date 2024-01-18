package com.example.erp_app.controller;

import com.example.erp_app.controller.request.EditOrderRequest;
import com.example.erp_app.controller.dto.AddOrderRequest;
import com.example.erp_app.controller.dto.OrderDto;
import com.example.erp_app.controller.dto.OrderDtoMapper;
import com.example.erp_app.model.Order;
import com.example.erp_app.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @RequestMapping( value = "/api/orders" , method = RequestMethod.GET)
    public ResponseEntity<List<OrderDto>> getOrders(){
        List<Order> orders = orderService.getOrders();
        return ResponseEntity.status(HttpStatus.OK).body(OrderDtoMapper.mapOrderDtos(orders));
    }

    @PostMapping("/api/addorder")
    public ResponseEntity<String> addOrder(@RequestBody AddOrderRequest addOrderRequest){
       String response =  orderService.addOrder(addOrderRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/order-edit")
    public ResponseEntity<String> editOrder(@RequestBody EditOrderRequest editOrderRequest){
       String response =  orderService.editOrder(editOrderRequest);

       if(response.equals("OK"))
           return ResponseEntity.ok(response);
       else
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

    }

    @PostMapping("/api/order")
    public ResponseEntity<OrderDto> getOrder(@RequestBody Map<String,Long> request){

        Long id = request.get("id");

        if(id == null) {
            return ResponseEntity.badRequest().build();
        }

        Order order = orderService.getOrder(id);

        return  ResponseEntity.ok(OrderDtoMapper.mapToOrderDto(order));
    }

}
