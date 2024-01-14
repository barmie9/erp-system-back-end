package com.example.erp_app.repository;

import com.example.erp_app.model.OrderSemiProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderSemiProductRepository extends JpaRepository<OrderSemiProduct, Long> {

    @Query("SELECT e FROM OrderSemiProduct e WHERE :orderId = e.order.id ORDER BY e.id DESC")
    Optional<List<OrderSemiProduct>> findAllByOrderId(@Param("orderId") Long orderId);
}
