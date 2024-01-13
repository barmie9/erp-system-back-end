package com.example.erp_app.repository;

import com.example.erp_app.model.SemiProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SemiProductRepository extends JpaRepository<SemiProduct, Long> {
    Optional<List<SemiProduct>> findAllByOrderByIdDesc();
}
