package com.example.erp_app.controller.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddDeviceRequest {
    private String name;
    private String descr;
    private Integer personNum;
}
