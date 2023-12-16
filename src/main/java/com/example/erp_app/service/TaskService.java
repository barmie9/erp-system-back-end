package com.example.erp_app.service;

//import com.example.erp_app.repository.*;
import com.example.erp_app.controller.request.AddTaskRequest;
import com.example.erp_app.controller.request.UpdateTaskProgressRequest;
import com.example.erp_app.controller.request.UpdateTaskRequest;
import com.example.erp_app.model.Order;
import com.example.erp_app.model.Task;
import com.example.erp_app.model.TaskFile;
import com.example.erp_app.model.User;
import com.example.erp_app.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final TaskFileRepository taskFileRepository;
    private final FileSystemTaskRepository fileSystemTaskRepository;

    public List<Task> getTasks(Long orderId){
        return taskRepository.findAllByOrderIdOrderByStart(orderId).orElseThrow();
    }

    public Task addTask(AddTaskRequest addTaskRequest) {

        // todo Do napisania obsługa przypadku gdy nie ma user lub order o danym id.
        User user = userRepository.findById(addTaskRequest.getUserId()).orElse(null);
        Order order = orderRepository.findById(addTaskRequest.getOrderId()).orElse(null);

        if(user==null || order==null){
            return null;
        }

        Task newTask = Task.builder()
                .name(addTaskRequest.getName())
                .descr(addTaskRequest.getDescr())
                .start(addTaskRequest.getStartDate())
                .end(addTaskRequest.getEndDate())
                .user(user)
                .order(order)
                .type("task")
                .progress(0)
                .build();

        taskRepository.save(newTask);

        return newTask;

    }

    public String addFilesToTask(List<MultipartFile> files, Long taskId) {

        Task task = taskRepository.findById(taskId).orElse(null);
        if(task == null){
            return "TASK NOT FOUND ID: " + taskId.toString();
        }

        for(MultipartFile file : files){

            // Zapis plików w systemie plików
            String location;
            try{
                location = fileSystemTaskRepository.save(file.getBytes(),file.getOriginalFilename());
            }catch (Exception e){
                System.out.println("SAVE FILE ERROR: " + e.getMessage());
                return "SAVE_FILE_ERROR: " + file.getOriginalFilename(); // Zwrócenie komunikatu z błędem jeśli nie udało się zapisać pliku
            }

            // Zapis w bazie danych lokalizacji plików
            TaskFile newTaskFile = new TaskFile();
            newTaskFile.setLocation(location);
            newTaskFile.setName(file.getOriginalFilename());
            newTaskFile.setTask(task);
            taskFileRepository.save(newTaskFile);
        }

        return "OK";
    }

    public FileSystemResource find(Long fileId) {
        TaskFile file = taskFileRepository.findById(fileId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return fileSystemTaskRepository.findInFileSystem(file.getLocation());
    }

    public List<Task> getUserTasks(Long userId) {
//        return taskRepository.findAllByUserId(userId).orElseThrow();
        return taskRepository.findAllByUserIdOrderByIdDesc(userId).orElseThrow();
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElseThrow();
    }

    public Task updateTaskProgress(UpdateTaskProgressRequest request) {
        Task task = taskRepository.findById(request.getTaskId()).orElseThrow();
        task.setProgress(request.getProgress());

        taskRepository.save(task);

        return task;
    }

    public Task updateTask(UpdateTaskRequest request) {
        Task task = taskRepository.findById(request.getTaskId()).orElse(null);

        if(task != null){
            task.setName(request.getName());
            task.setDescr(request.getDescr());
            task.setStart(request.getStart());
            task.setEnd(request.getEnd());
            task.setProgress(request.getProgress());

            return taskRepository.save(task);
        }
        else return null;
    }
}
