package com.example.erp_app.service;

import com.example.erp_app.dto.SemiProductDto;
import com.example.erp_app.model.SemiProduct;
import com.example.erp_app.repository.SemiProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SemiProductService {

    private final SemiProductRepository semiProductRepository;

    public List<SemiProduct> getSemiProducts(){
        return semiProductRepository.findAll();
    }

    public void addSemiProduct(SemiProductDto semiProductData){
        SemiProduct semiProduct = new SemiProduct();
//        semiProduct.setId(7);
        semiProduct.setName(semiProductData.getName());
        semiProduct.setDescr(semiProductData.getDescr());
        semiProduct.setProdDate( LocalDate.parse(semiProductData.getProdDate()) );
        semiProductRepository.save(semiProduct);
    }
}
