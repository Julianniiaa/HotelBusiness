package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.RoomType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoomViewRepositoryTest {

    @Autowired
    RoomViewRepository roomViewRepository;

    @Test
    void findById() {
        Assertions.assertNotNull(roomViewRepository.findById(1));
        Assertions.assertEquals(300, roomViewRepository.findById(2).getPrice());
    }
}