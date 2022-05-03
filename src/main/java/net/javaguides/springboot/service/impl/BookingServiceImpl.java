package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.model.Booking;
import net.javaguides.springboot.model.CustomService;
import net.javaguides.springboot.model.RoomView;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.BookingRepository;
import net.javaguides.springboot.repository.CustomServiceRepository;
import net.javaguides.springboot.repository.RoomViewRepository;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.BookingService;
import net.javaguides.springboot.web.dto.BookingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private RoomViewRepository roomViewRepository;

    @Autowired
    private CustomServiceRepository customServiceRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        super();
        this.bookingRepository= bookingRepository;
    }

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
//
//    @Override
//    public List<Booking> findByUser() {
//        User user = userRepository.findByEmail(getCurrentUsername());
//        System.out.println("АЙДИ ПОЛЬЗОВАТЕЛЯ :" + user.getId());
////        List<Booking> bookings = bookingRepository.getBookingById(user.getId());
////        List<Booking> bookings = Collections.singletonList(bookingRepository.findByUser(user.getId()));
////        List<Booking> bookings = (List<Booking>) bookingRepository.findByUserIn(getCurrentUsername());
//        return bookingRepository.findBookingById(user.getId());
//    }

    @Override
    public Booking saveBooking(BookingDto bookingDto) {
        RoomView roomView = roomViewRepository.findById(bookingDto.getIdRoom());
        CustomService customService = customServiceRepository.findById(bookingDto.getIdService());
        Set<CustomService> customServiceSet = new HashSet<CustomService>(Collections.singleton(customService));
        User user = userRepository.findByEmail(getCurrentUsername());

        Booking booking = new Booking(bookingDto.getDateBegin(),
                bookingDto.getDateEnd(),
                roomView.getPrice() * bookingDto.getColDay(),
                customService.getPrice() * bookingDto.getColDay(),
                bookingDto.getColDay(),
                roomView,
                user,
                customServiceSet);

        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> allBooking() {
        return bookingRepository.findAll();
    }
}
