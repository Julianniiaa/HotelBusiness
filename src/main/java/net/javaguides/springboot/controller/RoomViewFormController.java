package net.javaguides.springboot.controller;

import net.javaguides.springboot.repository.RoomTypeRepository;
import net.javaguides.springboot.service.RoomTypeService;
import net.javaguides.springboot.service.RoomViewService;
import net.javaguides.springboot.web.dto.RoomViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/room_form")
public class RoomViewFormController {

    @Autowired
    private RoomViewService roomViewService;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private RoomTypeService roomTypeService;

    public RoomViewFormController(RoomViewService roomViewService) {
        super();
        this.roomViewService = roomViewService;
    }


    @ModelAttribute("roomView")
    public RoomViewDto RoomViewRegistration(Model model, RoomViewDto roomViewDto) {
        List<String> listTypeOfRooms = Arrays.asList("Standard", "Lux");
        model.addAttribute("roomTypes", listTypeOfRooms);
        return new RoomViewDto();
    }

    @GetMapping
    public String showRegistrationRoomForm(Model model) {
        return "room_form";
    }

    @PostMapping
    public String registerRoomView(@ModelAttribute("roomView") RoomViewDto roomViewDto, Model model) {
        roomViewDto.setStatusBooking("Свободный");
        roomViewService.saveRoomView(roomViewDto);
        return "redirect:/room_form";
    }

}