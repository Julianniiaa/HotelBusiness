package net.javaguides.springboot.web.dto;

import net.javaguides.springboot.model.User;

public class CommentDto {

    private Long id;

    private String comment;

    private User user;

    private String email;

    public CommentDto() {
    }

    public CommentDto(String comment, User user) {
        this.comment = comment;
        this.user = user;
    }

    public CommentDto(Long id, String comment, User user) {
        this.id = id;
        this.comment = comment;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
