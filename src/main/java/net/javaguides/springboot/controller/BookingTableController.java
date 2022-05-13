package net.javaguides.springboot.controller;


import net.javaguides.springboot.model.Booking;
import net.javaguides.springboot.service.BookingService;
import net.javaguides.springboot.service.CustomServices;
import net.javaguides.springboot.service.RoomViewService;
import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.web.dto.BookingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/booking_table")
public class BookingTableController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private RoomViewService roomViewService;

    @Autowired
    private CustomServices customServices;

    @Autowired
    private UserService userService;

    public BookingTableController(BookingService bookingService) {
        super();
        this.bookingService = bookingService;
    }

    @GetMapping
    public String showBooking(Model model) {
        return "booking_table";
    }


    @ModelAttribute("booking")
    public BookingDto booking(Model model, BookingDto bookingDto) {

        List<Booking> bookingList = bookingService.allBooking();

        model.addAttribute("listBooking", bookingList);
        return new BookingDto();
    }

}
