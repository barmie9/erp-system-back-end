package com.example.erp_app.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTaskProgressRequest {
    private Long taskId;
    private Integer progress;
}
