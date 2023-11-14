package com.example.erp_app.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {
    private String name;
    private Long quantity;
    private LocalDate createDate;

    private LocalDate expectDate;
    private LocalDate realDate;

    private Long orderManagerId;
    private Long companyOrderId;

}
