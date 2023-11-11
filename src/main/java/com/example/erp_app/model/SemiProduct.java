package com.example.erp_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class SemiProduct {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) // Do sprawdzenia autoinkrementacja w insertach
    private Long id;
    private String name;
    private String descr;
    private LocalDate prodDate; //to check
}
