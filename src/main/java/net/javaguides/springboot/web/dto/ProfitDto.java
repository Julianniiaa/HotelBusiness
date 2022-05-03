package net.javaguides.springboot.web.dto;

public class ProfitDto {

    private int totalPrice;
    private int totalPriceLux;
    private int totalPriceStandart;

    public ProfitDto() {
    }

    public ProfitDto(int totalPrice, int totalPriceLux, int totalPriceStandart) {
        this.totalPrice = totalPrice;
        this.totalPriceLux = totalPriceLux;
        this.totalPriceStandart = totalPriceStandart;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalPriceLux() {
        return totalPriceLux;
    }

    public void setTotalPriceLux(int totalPriceLux) {
        this.totalPriceLux = totalPriceLux;
    }

    public int getTotalPriceStandart() {
        return totalPriceStandart;
    }

    public void setTotalPriceStandart(int totalPriceStandart) {
        this.totalPriceStandart = totalPriceStandart;
    }
}
