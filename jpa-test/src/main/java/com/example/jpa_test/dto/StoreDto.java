package com.example.jpa_test.dto;

import com.example.jpa_test.store.domain.Store;
import com.example.jpa_test.user.response.UserResponse;

public record StoreDto(
        Long id,
        String name,
        String address
) {
    public static StoreDto from(Store store){
        return new StoreDto(
                store.getId()
                , store.getName()
                , store.getAddress()
        );
    }
}