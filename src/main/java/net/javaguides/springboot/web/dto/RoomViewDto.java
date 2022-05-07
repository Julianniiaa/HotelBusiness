package net.javaguides.springboot.web.dto;

import net.javaguides.springboot.model.RoomType;

public class RoomViewDto {

    private Long id;

    private int colPeople;
    private int price;
    private int number;

    private String statusBooking;

    private int floor;
    private RoomType typeRoom;

    public RoomViewDto() {
    }

    public RoomViewDto(int colPeople, int price, int number, int floor) {
        this.colPeople = colPeople;
        this.price = price;
        this.number = number;
        this.floor = floor;
    }

    public RoomViewDto(int colPeople, int price) {
        this.colPeople = colPeople;
        this.price = price;


    }

    public RoomViewDto(int colPeople, int price, RoomType typeRoom) {
        this.colPeople = colPeople;
        this.price = price;
        this.typeRoom = typeRoom;
    }

    public RoomViewDto(int colPeople, int price, int number, int floor, RoomType typeRoom) {
        this.colPeople = colPeople;
        this.price = price;
        this.number = number;
        this.floor = floor;
        this.typeRoom = typeRoom;
    }



    public RoomViewDto(Long id, int colPeople, int price, int number, int floor, RoomType typeRoom) {
        this.id = id;
        this.colPeople = colPeople;
        this.price = price;
        this.number = number;
        this.floor = floor;
        this.typeRoom = typeRoom;
    }

    public RoomViewDto(int colPeople, int price, int number, String statusBooking, int floor, RoomType typeRoom) {
        this.colPeople = colPeople;
        this.price = price;
        this.number = number;
        this.statusBooking = statusBooking;
        this.floor = floor;
        this.typeRoom = typeRoom;
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

    public RoomType getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(RoomType typeRoom) {
        this.typeRoom = typeRoom;
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
