package net.javaguides.springboot.controller;

import net.javaguides.springboot.service.CommentService;
import net.javaguides.springboot.web.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class CommentController {

    @Autowired
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        super();
        this.commentService = commentService;
    }

    @GetMapping
    public String contact() {
        return "contact";
    }

    @ModelAttribute("contact")
    public CommentDto bookingRegistration() {
        return new CommentDto();
    }

    @PostMapping
    public String registerContact(@ModelAttribute("contact") CommentDto commentDto, Model model) {
        commentService.saveComment(commentDto);
        return "redirect:/contact";
    }

}
