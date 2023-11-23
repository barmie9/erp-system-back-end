package com.example.erp_app.repository;

import com.example.erp_app.model.TaskFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskFileRepository extends JpaRepository<TaskFile,Long> {

    Optional<List<TaskFile>> findAllByTaskId(Long taskId);
}
