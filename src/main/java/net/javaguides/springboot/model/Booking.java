package net.javaguides.springboot.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "Booking")
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dateBegin")
    private LocalDate dateBegin;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dateEnd")
    private LocalDate dateEnd;

    @Column(name = "priceRoom")
    private int priceRoom;

    @Column(name = "priceService")
    private int priceService;

    @Column(name = "colDay")
    private int colDay;

    @ManyToOne
    @JoinColumn(name = "id_room")
    private RoomView roomView;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_serv",
            joinColumns = @JoinColumn(name = "id_book", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_service", referencedColumnName = "id"))
    private Set<CustomService> customServices = new HashSet<CustomService>();

    public Booking() {
    }

    public Booking(LocalDate dateBegin, LocalDate dateEnd, int priceRoom) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.priceRoom = priceRoom;
    }

    public Booking(Long id, LocalDate dateBegin, LocalDate dateEnd, int priceRoom) {
        this.id = id;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.priceRoom = priceRoom;
    }

    public Booking(Long id, LocalDate dateBegin, LocalDate dateEnd, int priceRoom, int priceService) {
        this.id = id;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.priceRoom = priceRoom;
        this.priceService = priceService;
    }

    public Booking(LocalDate dateBegin, LocalDate dateEnd, int priceRoom, int priceService, int colDay, RoomView roomView, User user, Set<CustomService> customServices) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.priceRoom = priceRoom;
        this.priceService = priceService;
        this.colDay = colDay;
        this.roomView = roomView;
        this.user = user;
        this.customServices = customServices;
    }

    public Booking(LocalDate dateBegin, LocalDate dateEnd, int priceRoom, int priceService, int colDay, RoomView roomView) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.priceRoom = priceRoom;
        this.priceService = priceService;
        this.colDay = colDay;
        this.roomView = roomView;
    }

    public Booking(LocalDate dateBegin, LocalDate dateEnd, int priceRoom, int priceService, int colDay, RoomView roomView, Set<CustomService> customServices) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.priceRoom = priceRoom;
        this.priceService = priceService;
        this.colDay = colDay;
        this.roomView = roomView;
        this.customServices = customServices;
    }

    public Booking(LocalDate dateBegin, LocalDate dateEnd, int priceRoom, int priceService, int colDay, RoomView roomView, User user) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.priceRoom = priceRoom;
        this.priceService = priceService;
        this.colDay = colDay;
        this.roomView = roomView;
        this.user = user;
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

    public int getColDay() {
        return colDay;
    }

    public void setColDay(int colDay) {
        this.colDay = colDay;
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
}
