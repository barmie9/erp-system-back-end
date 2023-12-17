package com.example.erp_app.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCompanyRequest {
    private String name;
    private String phoneNumber;
    private String nipNumber;
}
