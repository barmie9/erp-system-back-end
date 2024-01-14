package com.example.erp_app.controller;

import com.example.erp_app.controller.request.AddOrderSemiProductRequest;
import com.example.erp_app.controller.request.UpdateOrderSemiProductQuantityRequest;
import com.example.erp_app.model.OrderSemiProduct;
import com.example.erp_app.service.OrderSemiProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderSemiProductController {

    private final OrderSemiProductService orderSemiProductService;

    @PostMapping("/api/get-order-semi-products")
    public ResponseEntity<List<OrderSemiProduct>> getOrderSemiProducts(@RequestBody HashMap<String, Long> request) {
        Long orderId = request.get("orderId");

        if (orderId != null) {
            return ResponseEntity.ok(orderSemiProductService.getOrderSemiProducts(orderId));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/api/add-order-semi-product")
    public ResponseEntity<String> addOrderSemiProduct(@RequestBody AddOrderSemiProductRequest request) {

        String response = orderSemiProductService.addOrderSemiProduct(request);

        return ResponseEntity.ok(response);

    }

    @PostMapping("/api/update-order-semi-product-quantity")
    public ResponseEntity<String> updateOrderSemiProductQuantity(
            @RequestBody UpdateOrderSemiProductQuantityRequest request) {
        String response = orderSemiProductService.updateOrderSemiProductQuantity(request);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/delete-order-semi-product")
    public ResponseEntity<String> deleteOrderSemiProduct(@RequestBody HashMap<String, Long> request) {
        Long id = request.get("id");
        if (id == null)
            return ResponseEntity.badRequest().build();

        String response = orderSemiProductService.deleteOrderSemiProduct(id);
        return ResponseEntity.ok(response);
    }
}
