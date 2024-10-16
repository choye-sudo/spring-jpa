package com.example.jpa_test.order.repository;

import com.example.jpa_test.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository
        extends JpaRepository<Order, Long> {
}