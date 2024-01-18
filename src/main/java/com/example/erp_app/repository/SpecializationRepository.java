package com.example.erp_app.repository;

import com.example.erp_app.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization,Long> {
    Optional<Specialization> findById(Long id);
}
