package net.javaguides.springboot.web.dto;

import net.javaguides.springboot.model.CustomService;

public class EmployeeServiceDto {

    private int numberRoom;
    private int floor;
    private CustomService customService;

    public EmployeeServiceDto() {
    }

    public EmployeeServiceDto(int numberRoom, int floor, CustomService customService) {
        this.numberRoom = numberRoom;
        this.floor = floor;
        this.customService = customService;
    }

    public EmployeeServiceDto(int numberRoom, int floor) {
        this.numberRoom = numberRoom;
        this.floor = floor;
    }

    public EmployeeServiceDto(CustomService customService) {
        this.customService = customService;
    }

    public int getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(int numberRoom) {
        this.numberRoom = numberRoom;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public CustomService getCustomService() {
        return customService;
    }

    public void setCustomService(CustomService customService) {
        this.customService = customService;
    }
}
