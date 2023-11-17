package com.example.erp_app.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String descr;
    private Integer progress;
    @Column(name = "start_date")
    private LocalDate start;
    @Column(name = "end_date")
    private LocalDate end;
    private String type;

//    @JsonIgnoreProperties({"hibernateLazyInitializer"})
//    @OneToOne(fetch = FetchType.LAZY)  // Do sprawdzenia
    @OneToOne
    @JoinColumn (name = "user_id")
    private User user;

//    @JsonIgnoreProperties({"hibernateLazyInitializer"})
//    @OneToOne(fetch = FetchType.LAZY)  // Do sprawdzenia
    @OneToOne
    @JoinColumn (name = "order_id")
    private Order order;
}
