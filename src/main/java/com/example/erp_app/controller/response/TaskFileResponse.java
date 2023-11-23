package com.example.erp_app.controller.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskFileResponse {
    private Long fileId;
    private String name;

}
