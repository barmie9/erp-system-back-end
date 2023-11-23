package com.example.erp_app.dto.mapper;

import com.example.erp_app.controller.response.TaskFileResponse;
import com.example.erp_app.model.TaskFile;

import java.util.List;
import java.util.stream.Collectors;

public class TaskFileResponseMapper {

    private TaskFileResponseMapper(){};


    public static TaskFileResponse mapToTaskFileResponse(TaskFile taskFile){
        return TaskFileResponse.builder()
                .fileId(taskFile.getId())
                .name(taskFile.getName())
                .build();
    }

    public static List<TaskFileResponse> mapToTaskFileResponses(List<TaskFile> taskFiles){
        return taskFiles.stream()
                .map(TaskFileResponseMapper::mapToTaskFileResponse)
                .collect(Collectors.toList());
    }

}
