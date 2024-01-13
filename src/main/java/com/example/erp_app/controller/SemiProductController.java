package com.example.erp_app.controller;

import com.example.erp_app.controller.request.UpdateSemiProductQuantityRequest;
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

    @GetMapping("/api/semi-products")
    public ResponseEntity<List<SemiProduct>> getSemiProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(semiProductService.getSemiProducts());
    }

    @RequestMapping(value = "/api/add-semi-product", method = RequestMethod.POST)
    public ResponseEntity<HashMap<String, String>> addSemiProduct(@RequestBody SemiProductDto semiProductData) {
        HashMap<String, String> response = new HashMap<>();
        semiProductService.addSemiProduct(semiProductData);
        response.put("keyy", "valuee");

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/api/update-semi-product-quantity")
    public ResponseEntity<String> updateSemiProductQuantity(@RequestBody UpdateSemiProductQuantityRequest request) {
        String response = semiProductService.updateSemiProductQuantity(request);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/delete-semi-product")
    public ResponseEntity<String> deleteSemiProduct(@RequestBody HashMap<String, Long> request) {
        Long id = request.get("id");
        if (id == null)
            return ResponseEntity.badRequest().build();
        else {
            String response = semiProductService.deleteSemiProduct(id);
            return ResponseEntity.ok(response);
        }

    }
}
