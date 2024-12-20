package com.example.erp_app.service;

import com.example.erp_app.config.JwtService;
import com.example.erp_app.controller.request.UpdateRoleRequest;
import com.example.erp_app.controller.response.AuthenticationResponse;
import com.example.erp_app.controller.dto.LoginRequest;
import com.example.erp_app.controller.dto.RegisterRequest;
import com.example.erp_app.model.Role;
import com.example.erp_app.model.Specialization;
import com.example.erp_app.model.User;
import com.example.erp_app.repository.SpecializationRepository;
import com.example.erp_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final SpecializationRepository specializationRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;



    public AuthenticationResponse register(RegisterRequest registerRequest) {

        // todo Do napisania obsługa przypadku gdy nie ma danej specjalizacji
        Specialization specialization = specializationRepository.findById(registerRequest.getSpecId()).orElseThrow();

        var user = User.builder()
                .email(registerRequest.getEmail())
                .pesel(registerRequest.getPesel())
                .name(registerRequest.getName())
                .phoneNum(registerRequest.getPhoneNum())
                .surname(registerRequest.getSurname())
                .specialization(specialization)
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .dOB(LocalDate.parse(registerRequest.getDateOfBirthday())) // DO SPRAWDZENIA
                .role(Role.USER)
                .build();

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .role(user.getRole().name())
                .userId(user.getId())
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
                .userId(user.getId())
                .build();
    }

    public List<User> getUsers() {
        return userRepository.findAllByOrderBySurname();
    }

    public String updateRole(UpdateRoleRequest request) {
        User user = userRepository.findById(request.getUserId()).orElse(null);

        if(user == null)
            return "ERROR: User not found by id: " + request.getUserId();

        if(request.getRole().equals("ADMIN"))
            user.setRole(Role.ADMIN);
        else
            user.setRole(Role.USER);

        userRepository.save(user);

        return "OK";
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
