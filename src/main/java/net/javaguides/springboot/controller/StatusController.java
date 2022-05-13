package net.javaguides.springboot.controller;

import net.javaguides.springboot.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StatusController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/changeStatus/{id}")
    public String changeStatus(@PathVariable(value = "id") long id) {
        bookingService.changeStatus(id);
        return "redirect:/user";
    }
}
