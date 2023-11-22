package com.example.erp_app.controller.request;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddTaskRequest {
    private String name;
    private String descr;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long userId;
    private Long orderId;
}
