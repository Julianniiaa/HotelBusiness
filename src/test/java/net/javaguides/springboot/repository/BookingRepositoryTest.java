package net.javaguides.springboot.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookingRepositoryTest {

    @Autowired
    private BookingRepository bookingRepository;

    @Test
    void TestGetBooking() throws SQLException, ClassNotFoundException {
        Assertions.assertNotNull(bookingRepository.findBookingByUserId(2));
        Assertions.assertEquals(1000, bookingRepository.
                findBookingByUserId(9).get(0).getPriceRoom());
    }

}