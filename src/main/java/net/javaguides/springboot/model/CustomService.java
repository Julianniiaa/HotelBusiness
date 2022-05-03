package net.javaguides.springboot.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Service")
public class CustomService implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price")
    private int price;

    @Column(name = "type")
    private String type;

    public CustomService() {
    }

    public CustomService(String type){
        super();
        this.type = type;
    }
    public CustomService(Long id, int price, String type) {
        this.id = id;
        this.price = price;
        this.type = type;
    }

    public CustomService(int price, String type) {
        this.price = price;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
