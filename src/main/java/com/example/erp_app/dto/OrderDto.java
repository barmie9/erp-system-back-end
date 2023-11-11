package com.example.erp_app.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderDto {
    Long id;
    String name;
    Long quantity;
    String createDate;
    Long expectDays;
    Long realDays;
    String orderManager;
    String companyOrder;
}
