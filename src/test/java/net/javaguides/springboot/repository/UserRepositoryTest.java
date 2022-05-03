package net.javaguides.springboot.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByEmail() {
        Assertions.assertNotNull(userRepository.findByEmail("admin@yandex.by"));
        Assertions.assertEquals("Юлия", userRepository.findByEmail("bsuir.gruppa602@mail.ru").
                getFirstName());
    }
}