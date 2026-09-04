package com.opensource.contributiontracker.service;

import com.opensource.contributiontracker.dto.UserResponse;
import com.opensource.contributiontracker.entity.User;
import com.opensource.contributiontracker.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private final UserRepository userRepository = Mockito.mock(UserRepository.class);

    private final UserService userService = new UserService(userRepository);

    @Test
    void getUserByIdShouldReturnUser() {

        User user = new User();

        user.setUsername("developer01");
        user.setEmail("developer01@example.com");
        user.setCreatedAt(java.time.LocalDateTime.now());

        Mockito.when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        UserResponse response = userService.getUserById(1L);

        assertEquals("developer01", response.getUsername());
        assertEquals(
                "developer01@example.com",
                response.getEmail());
    }
}
