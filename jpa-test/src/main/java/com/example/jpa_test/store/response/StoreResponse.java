package com.example.jpa_test.store.response;

import com.example.jpa_test.dto.UserDto;
import com.example.jpa_test.store.domain.Store;

public record StoreResponse(
        Long id,
        String name,
        String address,
        UserDto user
) {
    public static StoreResponse from(Store store){
        return new StoreResponse(
                store.getId()
                , store.getName()
                , store.getAddress()
                , UserDto.from(store.getUser())
        );
    }
}