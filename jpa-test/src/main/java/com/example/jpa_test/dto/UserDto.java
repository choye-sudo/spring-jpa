package com.example.jpa_test.dto;

import com.example.jpa_test.store.response.StoreResponse;
import com.example.jpa_test.user.domain.User;

import java.util.List;

public record UserDto(
        Long id,
        String email,
        String username
) {
    public static UserDto from(User user){
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getUsername()
        );
    }
}