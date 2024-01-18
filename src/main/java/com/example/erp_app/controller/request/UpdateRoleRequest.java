package com.example.erp_app.controller.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRoleRequest {
    private Long userId;
    private String role;
}
