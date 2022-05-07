package net.javaguides.springboot.service;


import net.javaguides.springboot.model.Booking;
import net.javaguides.springboot.web.dto.BookingDto;

import java.util.List;

public interface BookingService {
    Booking saveBooking(BookingDto bookingDto);
    List<Booking> allBooking();
    Booking changeStatus(long id);


}
