package com.example.erp_app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long quantity;
    private LocalDate createDate;
    private Long expectDays;
    private Long realDays;

    // Do sprawdzenia:
    @OneToOne(fetch = FetchType.LAZY)  // Do sprawdzenia
//    @OneToOne
    @JoinColumn(name = "order_manager_id")
    private User user;
//    Long orderManagerId;

    @OneToOne(fetch = FetchType.LAZY)  // Do sprawdzenia
//    @OneToOne
    @JoinColumn(name = "company_order_id")
    private CompanyOrder companyOrder;
//    private Long companyOrderId;
}
