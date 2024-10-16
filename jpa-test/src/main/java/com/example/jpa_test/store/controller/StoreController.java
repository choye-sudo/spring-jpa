package com.example.jpa_test.store.controller;

import com.example.jpa_test.store.request.StoreRequest;
import com.example.jpa_test.store.response.StoreResponse;
import com.example.jpa_test.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;
    @GetMapping("/api/v1/stores")
    public List<StoreResponse> getAllStores(){
        return storeService.getAllStore();
    }
    @PostMapping("/api/v1/stores")
    public StoreResponse saveStore(
            @RequestBody StoreRequest request
    ){
        return storeService.saveStore(request);
    }
}