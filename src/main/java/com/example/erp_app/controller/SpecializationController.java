package com.example.erp_app.controller;

import com.example.erp_app.model.Specialization;
import com.example.erp_app.service.SpecializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SpecializationController {

    private final SpecializationService specializationService;


    @RequestMapping(value = "/api/auth/specializations", method = RequestMethod.GET)
    ResponseEntity<List<Specialization>> getSpecializations() {
        return ResponseEntity.status(HttpStatus.OK).body(specializationService.getSpecializations());
    }

    @PostMapping("/api/add-specialization")
    ResponseEntity<String> addSpecialization(@RequestBody HashMap<String, String> request) {
        String name = request.get("name");

        if (name == null)
            return ResponseEntity.badRequest().build();
        else {
            String response = specializationService.addSpecialization(name);
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("/api/delete-specialization")
    ResponseEntity<String> deleteSpecialization(@RequestBody HashMap<String, Long> request) {
        Long id = request.get("id");

        if (id == null)
            return ResponseEntity.badRequest().build();
        else {
            String response = specializationService.deleteSpecialization(id);
            return ResponseEntity.ok(response);
        }
    }
}
