package com.example.jpa_test.user.service;


import com.example.jpa_test.user.domain.User;
import com.example.jpa_test.user.repository.UserRepository;
import com.example.jpa_test.user.request.UserRequest;
import com.example.jpa_test.user.response.UserResponse;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public UserResponse createUser(UserRequest request) {
        User entity = request.toEntity();
        userRepository.save(entity);
        return UserResponse.from(entity);
    }

    @Override
    @Transactional
    public UserResponse updateUser(Long id, UserRequest request) {
        User user = userRepository.findById(id).orElseThrow();
        user.update(request);
        return UserResponse.from(user);
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow();
        return UserResponse.from(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(UserResponse::from)
                .toList();
    }
}