package com.example.jpa_test.order.domain;

import com.example.jpa_test.store.domain.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDERS")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id @Column(name = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long price;
    private String product_name;

    @ManyToOne
    @JoinColumn(name = "STORE_ID")
    private Store store;

}
