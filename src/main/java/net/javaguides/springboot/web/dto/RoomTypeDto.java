package net.javaguides.springboot.web.dto;

public class RoomTypeDto {
    private Long id;
    private String typeOfroom;

    public RoomTypeDto() {
    }

    public RoomTypeDto(Long id, String typeOfroom) {
        super();
        this.id = id;
        this.typeOfroom = typeOfroom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeOfroom() {
        return typeOfroom;
    }

    public void setTypeOfroom(String typeOfroom) {
        this.typeOfroom = typeOfroom;
    }
}
