package net.javaguides.springboot.web.dto;

public class CustomServiceDto {

    private Long id;

    private int price;

    private int type;

    public CustomServiceDto() {
    }

    public CustomServiceDto(Long id, int price, int type) {
        this.id = id;
        this.price = price;
        this.type = type;
    }

    public CustomServiceDto(int price, int type) {
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
