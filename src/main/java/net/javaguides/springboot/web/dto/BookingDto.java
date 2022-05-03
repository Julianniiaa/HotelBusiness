package net.javaguides.springboot.web.dto;

import net.javaguides.springboot.model.CustomService;
import net.javaguides.springboot.model.RoomView;
import net.javaguides.springboot.model.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

public class BookingDto {

    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateBegin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateEnd;
    private int priceRoom;
    private int priceService;
    private int colDay;
    private RoomView roomView;
    private User user;
    private Set<CustomService> customServices;

    private String typeOfService;

    private long idRoom;
    private long idService;
    private String email;

    private int totalPrice;

    public BookingDto() {
    }

    public BookingDto(Long id, LocalDate dateBegin, LocalDate dateEnd, int priceRoom, int priceService, RoomView roomView, User user, Set<CustomService> customServices) {
        this.id = id;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.priceRoom = priceRoom;
        this.priceService = priceService;
        this.roomView = roomView;
        this.user = user;
        this.customServices = customServices;
    }

    public BookingDto(LocalDate dateBegin, LocalDate dateEnd, int priceRoom, int priceService, RoomView roomView, User user, Set<CustomService> customServices) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.priceRoom = priceRoom;
        this.priceService = priceService;
        this.roomView = roomView;
        this.user = user;
        this.customServices = customServices;
    }

    public BookingDto(LocalDate dateBegin, LocalDate dateEnd, int priceRoom, int priceService) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.priceRoom = priceRoom;
        this.priceService = priceService;
    }

    public BookingDto(Long id, LocalDate dateBegin, LocalDate dateEnd, int priceRoom, int priceService, RoomView roomView, User user) {
        this.id = id;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.priceRoom = priceRoom;
        this.priceService = priceService;
        this.roomView = roomView;
        this.user = user;
    }

    public BookingDto(LocalDate dateBegin, LocalDate dateEnd, int priceRoom, int priceService, RoomView roomView, User user) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.priceRoom = priceRoom;
        this.priceService = priceService;
        this.roomView = roomView;
        this.user = user;
    }

    public BookingDto(LocalDate dateBegin, LocalDate dateEnd, int priceRoom, int priceService, RoomView roomView) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.priceRoom = priceRoom;
        this.priceService = priceService;
        this.roomView = roomView;
    }

    public BookingDto(LocalDate dateBegin, LocalDate dateEnd, int priceRoom, int priceService, int colDay, RoomView roomView, User user, Set<CustomService> customServices) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.priceRoom = priceRoom;
        this.priceService = priceService;
        this.colDay = colDay;
        this.roomView = roomView;
        this.user = user;
        this.customServices = customServices;
    }

    public BookingDto(LocalDate dateBegin, LocalDate dateEnd, int priceRoom, int priceService, int colDay, RoomView roomView) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.priceRoom = priceRoom;
        this.priceService = priceService;
        this.colDay = colDay;
        this.roomView = roomView;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(LocalDate dateBegin) {
        this.dateBegin = dateBegin;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getPriceRoom() {
        return priceRoom;
    }

    public void setPriceRoom(int priceRoom) {
        this.priceRoom = priceRoom;
    }

    public int getPriceService() {
        return priceService;
    }

    public void setPriceService(int priceService) {
        this.priceService = priceService;
    }

    public RoomView getRoomView() {
        return roomView;
    }

    public void setRoomView(RoomView roomView) {
        this.roomView = roomView;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<CustomService> getCustomServices() {
        return customServices;
    }

    public void setCustomServices(Set<CustomService> customServices) {
        this.customServices = customServices;
    }

    public int getColDay() {
        return colDay;
    }

    public void setColDay(int colDay) {
        this.colDay = colDay;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    public long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(long idRoom) {
        this.idRoom = idRoom;
    }

    public long getIdService() {
        return idService;
    }

    public void setIdService(long idService) {
        this.idService = idService;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTotalPrice() {
        return totalPrice = priceRoom + priceService;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
