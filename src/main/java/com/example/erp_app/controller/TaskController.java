package com.example.erp_app.controller;

import com.example.erp_app.controller.request.AddTaskRequest;
import com.example.erp_app.dto.TaskDto;
import com.example.erp_app.dto.TaskDtoMapper;
import com.example.erp_app.model.Task;
import com.example.erp_app.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/api/tasks")
    public ResponseEntity<List<TaskDto>> getTasks (@RequestBody Map<String,Long> taskRequest){
        Long orderId = taskRequest.get("orderId");

        if (orderId == null) {
            return ResponseEntity.badRequest().build();
        }

        List<Task> tasks = taskService.getTasks(orderId);

        return ResponseEntity.ok(TaskDtoMapper.mapToTaskDtos(tasks));
    }

    @PostMapping("/api/add-task")
    public ResponseEntity<String> addTask(@RequestBody AddTaskRequest addTaskRequest){
        String response = taskService.addTask(addTaskRequest);

        if(response.equals("OK")){
            response = "OK - New task added";
            return ResponseEntity.ok(response);
        }
        else {
            return ResponseEntity.badRequest().build();
        }

    }

}
