package com.example.jpa_test.user.service;

import com.example.jpa_test.user.domain.User;
import com.example.jpa_test.user.repository.UserRepository;
import com.example.jpa_test.user.response.UserResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserServiceTest {
    @Test
    void createUser() {

    }

    @Test
    void updateUser() {

    }

    @Test
    void deleteUserById() {
    }

    @Test
    void getUserById()
    {
        Long id = users.get(0).getId();

        UserResponse userById = userService.getUserById(id);

        assertNotNull(userById);
        assertEquals(id, userById.id());
        assertEquals(users.get(0).getEmail(), userById.email());
    }

    @Test
    void getUserById_failure_not_found()
    {
        Long id = users.get(0).getId();
        assertThrows(NoSuchElementException.class, ()-> userService.getUserById(id));
    }

    @Test
    void getAllUsers()
    {
        List<UserResponse> allUsers = userService.getAllUsers();

        assertEquals(10, allUsers.size());
        assertEquals(users.get(0).getId(), allUsers.get(0).id());
    }




    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    String email = "www@naver.com";
    String password = "1234";
    String username = "admin";
    List<User> users;
    @BeforeEach
    void setUp(){
        userService = new UserServiceImpl(userRepository);
        users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = User.builder()
                    .password(password)
                    .email(email + i)
                    .username(username + i)
                    .build();
            users.add(user);
        }
        userRepository.saveAll(users);
    }
}