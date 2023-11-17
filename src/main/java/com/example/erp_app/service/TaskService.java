package com.example.erp_app.service;

import com.example.erp_app.controller.request.AddTaskRequest;
import com.example.erp_app.model.Order;
import com.example.erp_app.model.Task;
import com.example.erp_app.model.User;
import com.example.erp_app.repository.OrderRepository;
import com.example.erp_app.repository.TaskRepository;
import com.example.erp_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public List<Task> getTasks(Long orderId){
        return taskRepository.findAllByOrderId(orderId).orElseThrow();
    }

    public String addTask(AddTaskRequest addTaskRequest) {

        // todo Do napisania obsługa przypadku gdy nie ma user lub order o danym id.
        User user = userRepository.findById(addTaskRequest.getUserId()).orElseThrow();
        Order order = orderRepository.findById(addTaskRequest.getOrderId()).orElseThrow();

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

        return "OK";

    }
}
