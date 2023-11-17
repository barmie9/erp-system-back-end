package com.example.erp_app.repository;

import com.example.erp_app.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {
//    @Query("SELECT * FROM _order ORDER BY create_date ASC")
//    List<Order> findAllByOrderByCreateDateAsc();
//    Optional<List<Order>> findAllByOrderByCreateDateDesc();
    Optional<List<Order>> findAllByOrderByIdDesc();

//    @Query("UPDATE _order o set o.name = :name WHERE c.id = :orderId")

}
