package com.example.jpa_test.store.service;

import com.example.jpa_test.store.domain.Store;
import com.example.jpa_test.store.repository.StoreRepository;
import com.example.jpa_test.store.request.StoreRequest;
import com.example.jpa_test.store.response.StoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{
    private final StoreRepository storeRepository;

    @Override
    public StoreResponse saveStore(StoreRequest storeRequest) {
        Store entity = storeRequest.toEntity();
        storeRepository.save(entity);
        return StoreResponse.from(entity);
    }

    @Override
    public List<StoreResponse> getAllStore() {
        return storeRepository.findJoinAll()
                .stream()
                .map(StoreResponse::from)
                .toList();
    }
}