package com.example.jpa_test.store.service;


import com.example.jpa_test.store.request.StoreRequest;
import com.example.jpa_test.store.response.StoreResponse;

import java.util.List;

public interface StoreService {
    StoreResponse saveStore(StoreRequest storeRequest);
    List<StoreResponse> getAllStore();
}