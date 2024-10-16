package com.example.jpa_test.user.controller;

import com.example.jpa_test.user.request.UserRequest;
import com.example.jpa_test.user.response.UserResponse;
import com.example.jpa_test.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/api/v1/users")
    public UserResponse save(
            @RequestBody UserRequest request
    ){
        return userService.createUser(request);
    }
    @GetMapping("/api/v1/users")
    public List<UserResponse> getAll(){
        return userService.getAllUsers();
    }
}