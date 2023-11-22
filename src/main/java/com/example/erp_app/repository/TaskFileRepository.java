package com.example.erp_app.repository;

import com.example.erp_app.model.TaskFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskFileRepository extends JpaRepository<TaskFile,Long> {

}
