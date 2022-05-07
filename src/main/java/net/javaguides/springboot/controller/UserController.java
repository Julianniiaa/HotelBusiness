package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.CustomService;
import net.javaguides.springboot.model.RoomView;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.BookingService;
import net.javaguides.springboot.service.CustomServices;
import net.javaguides.springboot.service.RoomViewService;
import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.web.dto.BookingDto;
import net.javaguides.springboot.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private RoomViewService roomViewService;

    @Autowired
    private CustomServices customServices;

    @Autowired
    private BookingService bookingService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @GetMapping("/user")
    public ModelAndView menuUser(){
        ModelAndView mav = new ModelAndView("user");
        User user = userService.getUserByEmail(getCurrentUsername());
        mav.addObject("user", user);
        return mav;
    }


    @GetMapping("/user_info/{id}")
    public String menuUser_Info(@PathVariable( name = "id") int id,Model model){
        User user = userService.getUserById(id);
        model.addAttribute("userData", user);
        return "/user_info";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("user") UserRegistrationDto user) {
        userService.save(user);
        return "redirect:";
    }


    @ModelAttribute("booking")
    public BookingDto bookingRegistration( Model model, BookingDto bookingDto) {
        List<RoomView> listTypeOfRooms = roomViewService.allRoomView();
        List<CustomService> listOfService = customServices.allService();
        List<RoomView> listFreeRooms = new ArrayList<>();

        for(RoomView roomView : listTypeOfRooms){
            if(roomView.getStatusBooking().equals("Свободный")){
                listFreeRooms.add(roomView);
            }
        }

        model.addAttribute("listService", listOfService);
        model.addAttribute("roomTypes", listFreeRooms);
        return new BookingDto();
    }

    @PostMapping
    public String registerBooking(@ModelAttribute("booking") BookingDto bookingDto, Model model) {
        bookingDto.setStatus("Активно");
        bookingService.saveBooking(bookingDto);
        return "redirect:/user";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update_user_info";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUserAdmin(@PathVariable (value = "id") long id) {
        this.userService.deleteUserById(id);
        return "redirect:";
    }





}
