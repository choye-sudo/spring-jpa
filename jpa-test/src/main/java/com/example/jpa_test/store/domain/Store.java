package com.example.jpa_test.store.domain;


import com.example.jpa_test.config.BaseEntity;
import com.example.jpa_test.order.domain.Order;
import com.example.jpa_test.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "STORES")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store extends BaseEntity {
    @Id
    @Column(name="STORE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @OneToMany(mappedBy = "store")
    private List<Order> orders;
}