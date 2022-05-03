package net.javaguides.springboot.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
@Table(name = "RoomType")
public class RoomType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "type")
    private String type;


    public RoomType() {
    }


    public RoomType(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public RoomType(String type) {
        this.type = type;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
