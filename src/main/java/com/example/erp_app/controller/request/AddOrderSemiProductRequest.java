package com.example.erp_app.controller.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderSemiProductRequest {
    private Long orderId;
    private Long semiProductId;
    private Float quantity;
}
