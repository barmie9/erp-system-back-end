package com.example.erp_app.controller;

import com.example.erp_app.controller.request.AddCompanyRequest;
import com.example.erp_app.model.CompanyOrder;
import com.example.erp_app.repository.CompanyOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompanyOrderController {

    private final CompanyOrderRepository companyOrderRepository;

    @GetMapping("/api/company-orders")
    public ResponseEntity<List<CompanyOrder>> getCompanyOrders(){
        return ResponseEntity.ok(companyOrderRepository.findAll());
    }

    @PostMapping("/api/add-company")
    public ResponseEntity<CompanyOrder> addCompany(@RequestBody AddCompanyRequest request){

        if(request.getName().equals("") || request.getName() == null)
            return ResponseEntity.badRequest().build();

        CompanyOrder newCompany = new CompanyOrder();
        newCompany.setName(request.getName());
        newCompany.setPhoneNumber(request.getPhoneNumber().equals("") ? null : request.getPhoneNumber());
        newCompany.setNipNumber(request.getNipNumber().equals("") ? null : request.getNipNumber());

        return ResponseEntity.ok(companyOrderRepository.save(newCompany));
    }

    @DeleteMapping("/api/delete-company/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long companyId){
        System.out.println(companyId);

        CompanyOrder company = companyOrderRepository.findById(companyId).orElse(null);

        if(company != null){
            try{
                companyOrderRepository.delete(company);
                return ResponseEntity.ok("OK");
            }catch (Exception e){
                return ResponseEntity.ok("Nie mozna usunac pozycji: Do Firmy przydzielone sa zlecenia!");
            }

        }

        return ResponseEntity.ok("ERROR : Company not found by ID: " + companyId);
    }
}
