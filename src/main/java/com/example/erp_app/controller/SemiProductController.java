package com.example.erp_app.controller;

import com.example.erp_app.dto.SemiProductDto;
import com.example.erp_app.model.SemiProduct;
import com.example.erp_app.service.SemiProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SemiProductController {

    private final SemiProductService semiProductService;

    @GetMapping("/semiProducts")
    public ResponseEntity<List<SemiProduct>> getSemiProducts(){

        return ResponseEntity.status(HttpStatus.OK).body(semiProductService.getSemiProducts());
//        return semiProductService.getSemiProducts();
    }


    @RequestMapping(value="/addSemiProduct", method = RequestMethod.POST)
    public ResponseEntity<HashMap<String, String>> addSemiProduct(@RequestBody SemiProductDto semiProductData){
        HashMap<String,String> response = new HashMap<>();
        semiProductService.addSemiProduct(semiProductData);
        response.put("keyy","valuee");

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
