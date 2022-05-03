package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Booking;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.BookingRepository;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.BookingService;
import net.javaguides.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/booking_room/{id}")
public class RoomController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserService userService;


    public RoomController(BookingService bookingService){
        super();
        this.bookingService = bookingService;
    }

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @GetMapping
    public String bookingRoom(@PathVariable(name = "id") int id, Model model)
    {
        User user2 = userService.getUserById(id);
        model.addAttribute("user", user2);
        User user = userRepository.findByEmail(getCurrentUsername());
        List<Booking> booking = bookingRepository.findBookingByUserId(user.getId());
        model.addAttribute("listBooking", booking);
        return "/booking_room";
    }


//    @Autowired
//    private RoomViewService roomViewService;
//
//    @Autowired
//    private RoomTypeRepository roomTypeRepository;
//
//
//    public RoomController(RoomViewService roomViewService) {
//        super();
//        this.roomViewService = roomViewService;
//    }
//
//
//    @ModelAttribute("roomView")
//    public RoomViewDto RoomViewRegistration(Model model, RoomViewDto roomViewDto)
//    {
////        model.addAttribute("roomView", roomViewService.saveRoomView())
//        model.addAttribute("roomTypes", roomTypeRepository.findAll());
//        return new RoomViewDto();
//    }
//
//    @GetMapping
//    public String showRegistrationRoomForm(Model  model)
//    {
//        return "booking_form";
//    }
//
//    @PostMapping
//    public String registerRoomView(@ModelAttribute("roomView") RoomViewDto roomViewDto)
//    {
//        roomViewService.saveRoomView(roomViewDto);
//        return "redirect:/booking_form";
//    }


}
