package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Comment;
import net.javaguides.springboot.web.dto.CommentDto;

import java.util.List;

public interface CommentService {
    Comment saveComment(CommentDto commentDto);
    List<Comment> allComment();
}
