package com.example.erp_app.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long quantity;
    private LocalDate createDate;

    private LocalDate expectDate;
    private LocalDate realDate;

    // Do sprawdzenia:
    @OneToOne(fetch = FetchType.LAZY)  // Do sprawdzenia
//    @OneToOne
    @JoinColumn(name = "order_manager_id")
    private User orderManager;

    @OneToOne(fetch = FetchType.LAZY)  // Do sprawdzenia
//    @OneToOne
    @JoinColumn(name = "company_order_id")
    private CompanyOrder companyOrder;
}
