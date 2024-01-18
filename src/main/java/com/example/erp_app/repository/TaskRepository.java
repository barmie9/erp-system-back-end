package com.example.erp_app.repository;

import com.example.erp_app.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Zwraca liste zadań użytkownika, posortowaną po id malejąco
    Optional<List<Task>> findAllByUserIdOrderByIdDesc(Long userId);

    Optional<List<Task>> findAllByOrderIdOrderByStart(Long orderId);

    // Select pozwalający sprawdzić kolizje dat korzystania z maszyn dla nowych zadań
    @Query("SELECT e FROM Task e WHERE " +
            ":deviceId = e.device.id AND " +
            "(  (:newTaskStartDate BETWEEN e.start AND e.end OR :newTaskEndDate BETWEEN e.start AND e.end) OR " +
            "   (e.start BETWEEN :newTaskStartDate AND :newTaskEndDate " +
            "   OR e.end BETWEEN :newTaskStartDate AND :newTaskEndDate) )")
    Optional<List<Task>> findAllByDeviceDataCollision(
            @Param("deviceId") Long deviceId,
            @Param("newTaskStartDate") LocalDate newTaskStartDate,
            @Param("newTaskEndDate") LocalDate newTaskEndDate);

}
