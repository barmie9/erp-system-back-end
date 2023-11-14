package com.example.erp_app.controller;

import com.example.erp_app.dto.LoginRequest;
import com.example.erp_app.dto.RegisterRequest;
import com.example.erp_app.dto.UserDto;
import com.example.erp_app.dto.UserDtoMapper;
import com.example.erp_app.model.User;
import com.example.erp_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;



    @PostMapping("/api/auth/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){

        return ResponseEntity.ok(userService.register(registerRequest));

    }


    @PostMapping("/api/auth/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<UserDto>> getUsers(){
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(UserDtoMapper.mapToUserDtos(users));
    }


}
