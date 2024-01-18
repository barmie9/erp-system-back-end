package com.example.erp_app.service;

import com.example.erp_app.controller.request.UpdateSemiProductQuantityRequest;
import com.example.erp_app.controller.dto.SemiProductDto;
import com.example.erp_app.model.SemiProduct;
import com.example.erp_app.repository.SemiProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SemiProductService {

    private final SemiProductRepository semiProductRepository;

    public List<SemiProduct> getSemiProducts() {
        return semiProductRepository.findAllByOrderByIdDesc().orElseThrow();
    }

    public void addSemiProduct(SemiProductDto semiProductData) {
        SemiProduct semiProduct = new SemiProduct();
        semiProduct.setName(semiProductData.getName());
        semiProduct.setDescr(semiProductData.getDescr());
        semiProduct.setQuantity(semiProductData.getQuantity());
        semiProduct.setUnit(semiProductData.getUnit());
        semiProductRepository.save(semiProduct);
    }

    public String updateSemiProductQuantity(UpdateSemiProductQuantityRequest request) {
        SemiProduct semiProduct = semiProductRepository.findById(request.getId()).orElse(null);

        if (semiProduct == null) return "ERROR: semiProduct not found by id: " + request.getId();
        else {
            semiProduct.setQuantity(request.getQuantity());
            semiProductRepository.save(semiProduct);
            return "OK";
        }
    }

    public String deleteSemiProduct(Long id) {
        SemiProduct semiProduct = semiProductRepository.findById(id).orElse(null);

        if (semiProduct == null) return "ERROR: semiProduct not found by id: " + id;
        else {
            semiProductRepository.delete(semiProduct);
            return "OK";
        }
    }
}
