package net.javaguides.springboot.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomServiceRepositoryTest {

    @Autowired
    CustomServiceRepository customServiceRepository;

    @Test
    void findById() {
        Assertions.assertNotNull(customServiceRepository.findById(1L));
        Assertions.assertEquals("Бассейн", customServiceRepository.findById(2).getType());
    }

    @Test
    void findByType() {
        Assertions.assertNotNull(customServiceRepository.findByType("Спа"));
        Assertions.assertEquals("Спа", customServiceRepository.findByType("Спа").getType());
    }
}