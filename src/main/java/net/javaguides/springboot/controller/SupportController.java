package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Comment;
import net.javaguides.springboot.service.CommentService;
import net.javaguides.springboot.web.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/support")
public class SupportController {

    @Autowired
    private CommentService commentService;

    public SupportController(CommentService commentService) {
        super();
        this.commentService = commentService;
    }

    @ModelAttribute("support")
    public CommentDto Registration(Model model, CommentDto commentDto) {

        List<Comment> commentList = commentService.allComment();
        model.addAttribute("listComment", commentList);
        return new CommentDto();
    }

    @GetMapping
    public String showComment(Model model) {
        return "support";
    }

}
