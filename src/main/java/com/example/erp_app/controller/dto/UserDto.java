package com.example.erp_app.controller.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phoneNum;
    private String pesel;
    private LocalDate dOB;
    private String role;
    private String specialization;
}
