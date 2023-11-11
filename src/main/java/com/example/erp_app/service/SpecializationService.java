package com.example.erp_app.service;

import com.example.erp_app.model.Specialization;
import com.example.erp_app.repository.SpecializationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecializationService {

    private final SpecializationRepository specializationRepository;

    public List<Specialization> getSpecializations(){
        return specializationRepository.findAll();
    }

}
