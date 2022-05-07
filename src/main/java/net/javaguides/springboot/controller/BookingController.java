package net.javaguides.springboot.controller;


import net.javaguides.springboot.model.CustomService;
import net.javaguides.springboot.model.RoomView;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.BookingService;
import net.javaguides.springboot.service.CustomServices;
import net.javaguides.springboot.service.RoomViewService;
import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.web.dto.BookingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private RoomViewService roomViewService;

    @Autowired
    private CustomServices customServices;

    @Autowired
    private UserService userService;

    public BookingController(BookingService bookingService) {
        super();
        this.bookingService = bookingService;
    }

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @ModelAttribute("booking")
    public BookingDto bookingRegistration( Model model, BookingDto bookingDto) {
        List<RoomView> listTypeOfRooms = roomViewService.allRoomView();
        List<RoomView> listFreeRooms = new ArrayList<>();
        List<CustomService> listOfService =  customServices.allService();

        for(RoomView roomView : listTypeOfRooms){
            if(roomView.getStatusBooking().equals("Свободный")){
                listFreeRooms.add(roomView);
            }
        }


        User user = userService.getUserByEmail(getCurrentUsername());
        model.addAttribute("listService", listOfService);
        model.addAttribute("roomTypes", listFreeRooms);
        model.addAttribute("user", user);
        return new BookingDto();
    }

    @GetMapping
    public String showRegistrationBookingForm(Model model) {
        return "booking";
    }

    @PostMapping
    public String registerBooking(@ModelAttribute("booking") BookingDto bookingDto, Model model) {
        bookingDto.setStatus("Активно");
        bookingService.saveBooking(bookingDto);
        return "redirect:/booking";
    }



}
