package com.example.erp_app.service;

import com.example.erp_app.config.JwtService;
import com.example.erp_app.controller.AuthenticationResponse;
import com.example.erp_app.dto.LoginRequest;
import com.example.erp_app.dto.RegisterRequest;
import com.example.erp_app.model.Role;
import com.example.erp_app.model.User;
import com.example.erp_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;



    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = User.builder()
                .email(registerRequest.getEmail())
                .pesel(registerRequest.getPesel())
                .name(registerRequest.getName())
                .phoneNum(registerRequest.getPhoneNum())
                .surname(registerRequest.getSurname())
                .specId(registerRequest.getSpecId())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .dOB(LocalDate.parse(registerRequest.getDateOfBirthday())) // DO SPRAWDZENIA
                .role(Role.USER)
                .build();

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .role(user.getRole().name())
                .build();

    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        var user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .role(user.getRole().name())
                .build();
    }
}
