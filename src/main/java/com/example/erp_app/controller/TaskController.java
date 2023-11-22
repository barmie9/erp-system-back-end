package com.example.erp_app.controller;

import com.example.erp_app.controller.request.AddTaskRequest;
import com.example.erp_app.controller.request.UpdateTaskProgressRequest;
import com.example.erp_app.dto.TaskDto;
import com.example.erp_app.dto.TaskDtoMapper;
import com.example.erp_app.model.Task;
import com.example.erp_app.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/api/task")
    public ResponseEntity<TaskDto> getTask(@RequestBody Map<String,Long> request){
        Long taskId = request.get("taskId");
        if(taskId == null) return ResponseEntity.badRequest().build();

        Task task = taskService.getTaskById(taskId);
        return ResponseEntity.ok(TaskDtoMapper.mapToTaskDto(task));
    }

    @PostMapping("/api/user-tasks")
    public ResponseEntity<List<TaskDto>> getUserTasks(@RequestBody Map<String,Long> request){
        Long userId = request.get("userId");

        if (userId == null) {
            return ResponseEntity.badRequest().build();
        }
        List<Task> tasks = taskService.getUserTasks(userId);

        return ResponseEntity.ok(TaskDtoMapper.mapToTaskDtos(tasks));
    }

    @PostMapping("/api/add-task")
    public ResponseEntity<Long> addTask(@RequestBody AddTaskRequest addTaskRequest){
        Task task = taskService.addTask(addTaskRequest);

        if(task == null){
            return ResponseEntity.badRequest().body(null);
        }
        else {
            return ResponseEntity.ok(task.getId());
        }
    }

    @PostMapping("/api/add-task-files")
    public ResponseEntity<String> addTaskFiles(@RequestParam("files") List<MultipartFile> files, @RequestParam("taskId") Long taskId){

        String response = taskService.addFilesToTask(files,taskId);

        if(response.equals("OK"))
            return ResponseEntity.ok("OK - DODANO PLIKI");
        else
            return ResponseEntity.badRequest().body(response);
    }

    @PostMapping("/api/update-task-progress")
    public ResponseEntity<TaskDto> updateTaskProgress(@RequestBody UpdateTaskProgressRequest request){
        Task task = taskService.updateTaskProgress(request);

        return ResponseEntity.ok(TaskDtoMapper.mapToTaskDto(task));
    }

}
