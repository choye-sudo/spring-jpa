package com.example.jpa_test.order.domain;

import com.example.jpa_test.config.BaseEntity;
import com.example.jpa_test.store.domain.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;




@AllArgsConstructor @Entity
@NoArgsConstructor @Getter
@Table(name = "ORDERS", indexes = {@Index(columnList = "productName")})
public class Order extends BaseEntity {
    @Id
    @Column(name = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long price;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "STORE_ID")
    private Store store;
}