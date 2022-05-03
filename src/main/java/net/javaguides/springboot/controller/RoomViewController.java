package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.RoomView;
import net.javaguides.springboot.repository.RoomViewRepository;
import net.javaguides.springboot.service.RoomViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RoomViewController {

    @Autowired
    private RoomViewService roomViewService;

    @Autowired
    private RoomViewRepository roomViewRepository;

    public RoomViewController(RoomViewService roomViewService) {
        super();
        this.roomViewService = roomViewService;
    }

    @RequestMapping("/rs")
    public String showNewProductPage(Model model) {
        RoomView roomView = new RoomView();
        model.addAttribute("room", roomView);

        return "room_form";
    }


    @RequestMapping("/room_View")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<RoomView> list = roomViewService.allRoomView();
        model.addAttribute("listRoom", list);

        List<RoomView> listRoom = roomViewService.findByKeyword(keyword);
        model.addAttribute("keyword", keyword);
        model.addAttribute("list", listRoom);

        return "room_View";
    }



//    @RequestMapping("/room_View")
//    public String viewHomePage(Model model) {
//        List<RoomView> list = roomViewService.allRoomView();
//        model.addAttribute("listRoom", list);
//
//        return "room_View";
//    }

     private Long id3;

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_room");
        RoomView roomView = roomViewRepository.findById(id);
        Long id2 = roomView.getRoomType().getId();
        id3 = id2;
        mav.addObject("roomView", roomView);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        roomViewService.delete(id);
        return "redirect:/room_View";
    }

    @RequestMapping(value = "/save_room_view", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("room") RoomView roomView) {
        Long id = roomView.getRoomType().getId();
        roomView.getRoomType().setId(id3);
        roomViewService.save(roomView);
        return "redirect:/room_View";
    }
}
