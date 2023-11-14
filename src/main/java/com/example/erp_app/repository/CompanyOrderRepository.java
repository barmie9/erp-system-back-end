package com.example.erp_app.repository;

import com.example.erp_app.model.CompanyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyOrderRepository extends JpaRepository<CompanyOrder,Long> {
}
