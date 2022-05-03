package net.javaguides.springboot.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoomTypeRepositoryTest {

    @Autowired
    RoomTypeRepository roomTypeRepository;

    @Test
    void findByType() {
        Assertions.assertNotNull(roomTypeRepository.findByType("Standart"));
        Assertions.assertEquals("Lux", roomTypeRepository.findByType("Lux").getType());
    }
}