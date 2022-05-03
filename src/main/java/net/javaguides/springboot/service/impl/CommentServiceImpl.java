package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.model.Comment;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.CommentRepository;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.CommentService;
import net.javaguides.springboot.web.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        super();
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment saveComment(CommentDto commentDto) {
        User user = userRepository.findByEmail(commentDto.getEmail());
        Comment comment = new Comment(commentDto.getComment(),
                user);
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> allComment() {
        return commentRepository.findAll();
    }
}
