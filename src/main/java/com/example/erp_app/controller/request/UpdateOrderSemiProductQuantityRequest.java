package com.example.erp_app.controller.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderSemiProductQuantityRequest {
    private Long id;
    private Float quantity;
}
