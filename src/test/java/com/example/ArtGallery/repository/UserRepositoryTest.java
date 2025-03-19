package com.example.ArtGallery.repository;

import com.example.ArtGallery.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setUsername("John Doe");
        user.setEmail("john.doe@example.com");
        userRepository.save(user);
    }

    @Test
    void testFindById() {
        User foundUser = userRepository.findById(user.getId()).orElse(null);
        assertNotNull(foundUser);
        assertEquals("John Doe", foundUser.getUsername());
    }


    @Test
    void testDeleteById() {
        userRepository.deleteById(user.getId());
        assertFalse(userRepository.findById(user.getId()).isPresent());
    }
}
