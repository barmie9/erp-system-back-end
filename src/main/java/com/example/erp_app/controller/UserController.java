package com.example.erp_app.controller;

import com.example.erp_app.controller.request.UpdateRoleRequest;
import com.example.erp_app.controller.response.AuthenticationResponse;
import com.example.erp_app.controller.dto.LoginRequest;
import com.example.erp_app.controller.dto.RegisterRequest;
import com.example.erp_app.controller.dto.UserDto;
import com.example.erp_app.controller.dto.UserDtoMapper;
import com.example.erp_app.model.User;
import com.example.erp_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/api/auth/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) {

        return ResponseEntity.ok(userService.register(registerRequest));

    }


    @PostMapping("/api/auth/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(UserDtoMapper.mapToUserDtos(users));
    }

    @PostMapping("/api/user")
    public ResponseEntity<UserDto> getUser(@RequestBody HashMap<String, Long> request) {
        Long id = request.get("id");

        if (id != null) {
            User user = userService.getUser(id);
            if (user != null)
                return ResponseEntity.ok(UserDtoMapper.mapToUserDto(user));
            else
                return ResponseEntity.badRequest().build();
        } else
            return ResponseEntity.badRequest().build();
    }

    @PostMapping("/api/update-role")
    public ResponseEntity<String> updateRole(@RequestBody UpdateRoleRequest request) {
        String response = userService.updateRole(request);

        return ResponseEntity.ok(response);
    }


}
