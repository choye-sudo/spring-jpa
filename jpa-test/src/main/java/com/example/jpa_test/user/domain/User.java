package com.example.jpa_test.user.domain;

import ch.qos.logback.core.util.StringUtil;
import com.example.jpa_test.store.domain.Store;
import com.example.jpa_test.user.request.UserRequest;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "USERS",
        indexes = {
                @Index(columnList = "email"),
                @Index(columnList = "username")
        }
)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(length = 10, nullable = false)
    private String username;
    //   fetch = FetchType.EAGER
//    fetch = FetchType.LAZY default
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Store> stores = new ArrayList<>();





    public void update(UserRequest request){
        if(!StringUtil.isNullOrEmpty(request.password()))
            this.password = request.password();
        if(!StringUtil.isNullOrEmpty(request.username()))
            this.username = request.username();
    }
}