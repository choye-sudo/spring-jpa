package com.example.jpa_test.user.service;

import com.example.jpa_test.user.domain.User;
import com.example.jpa_test.user.repository.UserRepository;
import com.example.jpa_test.user.request.UserRequest;
import com.example.jpa_test.user.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public UserResponse createUser(UserRequest request) {
        return null;
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
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
