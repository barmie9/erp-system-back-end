package com.example.erp_app.controller;

import com.example.erp_app.model.CompanyOrder;
import com.example.erp_app.repository.CompanyOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompanyOrderController {

    private final CompanyOrderRepository companyOrderRepository;

    @GetMapping("/api/companyorders")
    public ResponseEntity<List<CompanyOrder>> getCompanyOrders(){
        return ResponseEntity.ok(companyOrderRepository.findAll());
    }
}
