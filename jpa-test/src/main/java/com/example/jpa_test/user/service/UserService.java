package com.example.jpa_test.user.service;

import com.example.jpa_test.user.request.UserRequest;
import com.example.jpa_test.user.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest request);
    UserResponse updateUser(Long id, UserRequest request);
    void deleteUserById(Long id);
    UserResponse getUserById(Long id);
    List<UserResponse> getAllUsers();

}