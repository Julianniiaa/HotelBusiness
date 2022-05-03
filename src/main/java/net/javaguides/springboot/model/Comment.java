package net.javaguides.springboot.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Comment() {
    }

    public Comment(Long id, String comment, User user) {
        this.id = id;
        this.comment = comment;
        this.user = user;
    }

    public Comment(String comment, User user) {
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
}
