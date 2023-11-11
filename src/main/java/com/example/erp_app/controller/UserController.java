package com.example.erp_app.controller;

import com.example.erp_app.dto.LoginRequest;
import com.example.erp_app.dto.RegisterRequest;
import com.example.erp_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @CrossOrigin
    @PostMapping("/api/auth/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){

        return ResponseEntity.ok(userService.register(registerRequest));

    }

    @CrossOrigin
    @PostMapping("/api/auth/login")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(userService.login(loginRequest));
    }


}
