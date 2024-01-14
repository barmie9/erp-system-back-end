package com.example.erp_app.service;

import com.example.erp_app.controller.request.AddOrderSemiProductRequest;
import com.example.erp_app.controller.request.UpdateOrderSemiProductQuantityRequest;
import com.example.erp_app.model.Order;
import com.example.erp_app.model.OrderSemiProduct;
import com.example.erp_app.model.SemiProduct;
import com.example.erp_app.repository.OrderRepository;
import com.example.erp_app.repository.OrderSemiProductRepository;
import com.example.erp_app.repository.SemiProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderSemiProductService {
    private final OrderSemiProductRepository orderSemiProductRepository;
    private final OrderRepository orderRepository;
    private final SemiProductRepository semiProductRepository;

    public List<OrderSemiProduct> getOrderSemiProducts(Long orderId) {
        List<OrderSemiProduct> orderSemiProducts = orderSemiProductRepository
                .findAllByOrderId(orderId).orElse(new ArrayList<>());

        return orderSemiProducts;
    }

    public String addOrderSemiProduct(AddOrderSemiProductRequest request) {
        Long orderId = request.getOrderId();
        Long semiProductId = request.getSemiProductId();
        Order order = orderRepository.findById(orderId).orElse(null);
        SemiProduct semiProduct = semiProductRepository.findById(semiProductId).orElse(null);

        if (order == null || semiProduct == null) {
            return "ERROR: not found order or semiProduct by id: orderId: "
                    + orderId + " , semiProductId: " + semiProductId;
        }

        OrderSemiProduct newOrderSemiProduct = new OrderSemiProduct();
        newOrderSemiProduct.setSemiProduct(semiProduct);
        newOrderSemiProduct.setOrder(order);
        newOrderSemiProduct.setQuantity(request.getQuantity());

        orderSemiProductRepository.save(newOrderSemiProduct);

        //Odjęcie od półproduktu jego ilości dodanej do zlecenia:
        semiProduct.setQuantity(semiProduct.getQuantity() - request.getQuantity());
        semiProductRepository.save(semiProduct);


        return "OK";

    }

    public String updateOrderSemiProductQuantity(UpdateOrderSemiProductQuantityRequest request) {
        OrderSemiProduct orderSemiProduct = orderSemiProductRepository.findById(request.getId()).orElse(null);
        if (orderSemiProduct == null)
            return "ERROR: orderSemiProduct not found by id: " + request.getId();

        SemiProduct semiProduct = semiProductRepository.findById(orderSemiProduct.getSemiProduct().getId()).orElse(null);
        if (orderSemiProduct == null)
            return "ERROR: semiProduct not found by id: " + orderSemiProduct.getSemiProduct().getId();

        float newSemiProdQuantity = semiProduct.getQuantity() + (orderSemiProduct.getQuantity() - request.getQuantity());
        semiProduct.setQuantity(newSemiProdQuantity);
        semiProductRepository.save(semiProduct);

        orderSemiProduct.setQuantity(request.getQuantity());
        orderSemiProductRepository.save(orderSemiProduct);

        return "OK";

    }

    public String deleteOrderSemiProduct(Long id) {
        OrderSemiProduct orderSemiProduct = orderSemiProductRepository.findById(id).orElse(null);
        if (orderSemiProduct == null)
            return "ERROR: orderSemiProduct not found by id: " + id;

        SemiProduct semiProduct = orderSemiProduct.getSemiProduct();

        semiProduct.setQuantity(semiProduct.getQuantity() + orderSemiProduct.getQuantity());

        semiProductRepository.save(semiProduct);

        orderSemiProductRepository.delete(orderSemiProduct);

        return "OK";
    }
}
