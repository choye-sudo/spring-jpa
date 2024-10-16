package com.example.jpa_test.store.request;

import com.example.jpa_test.store.domain.Store;
import com.example.jpa_test.user.domain.User;

import java.util.ArrayList;

public record StoreRequest(
        String name,
        String address,
        Long userId
) {
    public Store toEntity(){
        User user = User.builder().id(userId).build();
        return new Store(null, name, address, user, new ArrayList<>());
    }
}