package com.example.erp_app.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // Do sprawdzenia autoinkrementacja w insertach
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phoneNum;
    private String pesel;
    @Column(name = "d_o_b")
    private LocalDate dOB;

//    @Column(name = "role")
//    private String roleStr;

    //private Integer privilege;
    @Enumerated(EnumType.STRING)
    private Role role; // Uprawnienia

    @OneToOne(fetch = FetchType.LAZY)  // Do sprawdzenia
    @JoinColumn(name = "spec_id")
    private Specialization specialization;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
