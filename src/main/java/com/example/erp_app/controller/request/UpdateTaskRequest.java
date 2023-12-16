package com.example.erp_app.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateTaskRequest {
    private Long taskId;
    private Integer progress;
    private String name;
    private String descr;
    private LocalDate start;
    private LocalDate end;
}
