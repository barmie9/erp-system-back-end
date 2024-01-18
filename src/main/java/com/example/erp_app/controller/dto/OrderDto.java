package com.example.erp_app.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class OrderDto {
    private Long id;
    private String name;
    private Long quantity;
    private String createDate;

    private LocalDate expectDate;
    private LocalDate realDate;

    private String orderManager;
    private String companyOrder;
    private Long companyOrderId;
}
