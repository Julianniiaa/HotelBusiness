package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Booking;
import net.javaguides.springboot.model.CustomService;
import net.javaguides.springboot.repository.BookingRepository;
import net.javaguides.springboot.repository.CustomServiceRepository;
import net.javaguides.springboot.repository.RoomViewRepository;
import net.javaguides.springboot.service.CustomServices;
import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.web.dto.EmployeeServiceDto;
import net.javaguides.springboot.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomServiceRepository customServiceRepository;

    @Autowired
    private CustomServices customServices1;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomViewRepository roomViewRepository;

    public EmployeeController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("employee")
    public UserRegistrationDto bookingRegistration(Model model, UserRegistrationDto userRegistrationDto) {
        List<Booking> bookingList = bookingRepository.findAll();

        List<CustomService> customServices = new ArrayList<>();

            for (Booking bookings : bookingList) {
                customServices.addAll(bookings.getCustomServices());
            }

        List<CustomService> customServiceList = new ArrayList<>();
        List<EmployeeServiceDto> employeeServiceDtoList = new ArrayList<>();

            for (CustomService customService : customServices) {
                    customServiceList.add(customServiceRepository.findByType(customService.getType()));
                }

        CustomService customService = null;
            for (Booking booking : bookingList) {
                Set<CustomService> serviceSet = new HashSet<>();
            int number = 0;
            int floor = 0;
                number = booking.getRoomView().getNumber();
                floor = booking.getRoomView().getFloor();
                serviceSet = booking.getCustomServices();
                customService = (CustomService) Arrays.stream(Arrays.stream(serviceSet.toArray()).toArray()).findFirst().get();
                    EmployeeServiceDto employeeServiceDto = new EmployeeServiceDto(number, floor, customService);
                    employeeServiceDtoList.add(employeeServiceDto);
        }


        model.addAttribute("bookingList", bookingList);
        model.addAttribute("bookingListServ", customServiceList);
        model.addAttribute("listServ", employeeServiceDtoList);
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showEmployee(Model model) {
        return "employee";
    }


}
