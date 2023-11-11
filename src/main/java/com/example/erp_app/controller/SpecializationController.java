package com.example.erp_app.controller;

import com.example.erp_app.model.Specialization;
import com.example.erp_app.service.SpecializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SpecializationController {

    private final SpecializationService specializationService;

    @CrossOrigin
    @RequestMapping(value = "/specializations", method = RequestMethod.GET)
    ResponseEntity<List<Specialization>> getSpecializations (){
        return ResponseEntity.status(HttpStatus.OK).body(specializationService.getSpecializations());
    }
}
