package com.example.erp_app.repository;

import com.example.erp_app.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    Optional<List<Task>> findAllByOrderId(Long orderId);

//    Optional<List<Task>> findAllByUserId(Long userId);

    // Zwraca liste zadań użytkownika, posortowaną po id malejąco
    Optional<List<Task>> findAllByUserIdOrderByIdDesc(Long userId);
}
