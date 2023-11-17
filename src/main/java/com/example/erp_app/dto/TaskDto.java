package com.example.erp_app.dto;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long id;
    private String name;
    private String descr;
    private Integer progress;
    private LocalDate start;
    private LocalDate end;
    private String type;

    private String userName;
    private String userSurname;



}
