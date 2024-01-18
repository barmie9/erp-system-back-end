package com.example.erp_app.controller.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String phoneNum;
    private String pesel;
    private String dateOfBirthday;

    private Long specId;
}
