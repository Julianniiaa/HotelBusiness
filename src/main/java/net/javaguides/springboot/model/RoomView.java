package net.javaguides.springboot.model;

import javax.persistence.*;
import java.awt.print.Book;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "RoomView")
public class RoomView implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "colPeople")
    private int colPeople;

    @Column(name = "price")
    private int price;

    @Column(name = "number")
    private int number;

    @Column(name = "floor")
    private int floor;

    @Column(name = "statusBooking")
    private String statusBooking;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idRoomType")
    private RoomType roomType;

    public RoomView() {
    }

    public RoomView(Long id, int colPeople, int price) {
        this.id = id;
        this.colPeople = colPeople;
        this.price = price;
    }

    public RoomView(int colPeople, int price, RoomType roomType) {
        this.colPeople = colPeople;
        this.price = price;
        this.roomType = roomType;
    }

    public RoomView(Long id, int colPeople, int price, RoomType roomType) {
        this.id = id;
        this.colPeople = colPeople;
        this.price = price;
        this.roomType = roomType;
    }

    public RoomView(int colPeople, int price) {
        this.colPeople = colPeople;
        this.price = price;
    }

    public RoomView(Long id, int colPeople, int price, int number, int floor, RoomType roomType) {
        this.id = id;
        this.colPeople = colPeople;
        this.price = price;
        this.number = number;
        this.floor = floor;
        this.roomType = roomType;
    }

    public RoomView(int colPeople, int price, int number, int floor, RoomType roomType) {
        this.colPeople = colPeople;
        this.price = price;
        this.number = number;
        this.floor = floor;
        this.roomType = roomType;
    }

    public RoomView(int colPeople, int price, int number, int floor) {
        this.colPeople = colPeople;
        this.price = price;
        this.number = number;
        this.floor = floor;
    }

    public RoomView(int colPeople, int price, int number, int floor, String statusBooking, RoomType roomType) {
        this.colPeople = colPeople;
        this.price = price;
        this.number = number;
        this.floor = floor;
        this.statusBooking = statusBooking;
        this.roomType = roomType;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getColPeople() {
        return colPeople;
    }

    public void setColPeople(int colPeople) {
        this.colPeople = colPeople;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getStatusBooking() {
        return statusBooking;
    }

    public void setStatusBooking(String statusBooking) {
        this.statusBooking = statusBooking;
    }
}
