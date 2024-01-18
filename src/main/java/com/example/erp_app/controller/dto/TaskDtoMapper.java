package com.example.erp_app.controller.dto;

import com.example.erp_app.model.Task;

import java.util.List;
import java.util.stream.Collectors;

public class TaskDtoMapper {

    private  TaskDtoMapper(){}

    public static TaskDto mapToTaskDto(Task task){
        return TaskDto.builder()
                .id(task.getId())
                .name(task.getName())
                .descr(task.getDescr())
                .progress(task.getProgress())
                .start(task.getStart())
                .end(task.getEnd())
                .type(task.getType())
                .userName(task.getUser().getName())
                .userSurname(task.getUser().getSurname())
                .device(task.getDevice() == null
                        ? "brak"
                        : task.getDevice().getName() + " - " + task.getDevice().getDescr() )
                .build();
    }

    public static List<TaskDto> mapToTaskDtos(List<Task> tasks){
        return tasks.stream()
                .map(TaskDtoMapper::mapToTaskDto)
                .collect(Collectors.toList());
    }
}
