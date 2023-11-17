package com.example.erp_app.controller.request;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditOrderRequest {
    private Long id;
    private String name;
    private Long quantity;
    private Long companyOrderId;
    private LocalDate expectDate;
}
