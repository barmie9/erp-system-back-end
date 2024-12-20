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

    public String addSpecialization (String name){
        Specialization specialization= new Specialization();
        specialization.setName(name);

        specializationRepository.save(specialization);
        return name;
    }

    public String deleteSpecialization(Long id){
        Specialization specialization = specializationRepository.findById(id).orElse(null);

        if(specialization == null) return "ERROR: specialization not found by id: "+id;

        specializationRepository.delete(specialization);
        return "OK";
    }

}
