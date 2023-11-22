package com.example.erp_app.repository;

import com.example.erp_app.model.SemiProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemiProductRepository extends JpaRepository<SemiProduct,Long> {
}
