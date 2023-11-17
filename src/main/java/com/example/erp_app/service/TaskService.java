package com.example.erp_app.service;

import com.example.erp_app.model.Task;
import com.example.erp_app.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getTasks(Long orderId){
        return taskRepository.findAllByOrderId(orderId).orElseThrow();
    }

}
