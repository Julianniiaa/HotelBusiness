package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Booking;
import net.javaguides.springboot.repository.BookingRepository;
import net.javaguides.springboot.repository.RoomTypeRepository;
import net.javaguides.springboot.repository.RoomViewRepository;
import net.javaguides.springboot.web.dto.BookingDto;
import net.javaguides.springboot.web.dto.ProfitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/profit")
public class ProfitController {

    @Autowired
    private RoomViewRepository roomViewRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;


    @ModelAttribute("booking")
    public BookingDto showResultProfit(Model model) {
        List<Booking> bookingList = bookingRepository.findAll();

        int totalPrice = 0;
        for (Booking booking : bookingList){
            if(booking.getStatus().equals("Активно")) {
                totalPrice += booking.getPriceRoom();
            }
        }
        int totalPriceLux = 0;
        int totalPriceStandard = 0;
        for(Booking booking2 : bookingList){
            if(booking2.getRoomView().getRoomType().getType().equals("Lux") & booking2.getStatus().equals("Активно")) {
                totalPriceLux += booking2.getPriceRoom();
            } else if(booking2.getRoomView().getRoomType().getType().equals("Standard") & booking2.getStatus().equals("Активно")){
                totalPriceStandard += booking2.getPriceRoom();
            }
        }

        ProfitDto profitDto = new ProfitDto(totalPrice, totalPriceLux, totalPriceStandard);
        List<ProfitDto> profitDtoList = new ArrayList<>();
        profitDtoList.add(profitDto);
        model.addAttribute("totalPrice", profitDtoList);

        return new BookingDto();
    }

    @GetMapping
    public String profit() {
        return "profit";
    }


}
