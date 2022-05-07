package net.javaguides.springboot.web.dto;

public class ProfitDto {

    private int totalPrice;
    private int totalPriceLux;
    private int totalPriceStandard;

    public ProfitDto() {
    }

    public ProfitDto(int totalPrice, int totalPriceLux, int totalPriceStandard) {
        this.totalPrice = totalPrice;
        this.totalPriceLux = totalPriceLux;
        this.totalPriceStandard = totalPriceStandard;
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

    public int getTotalPriceStandard() {
        return totalPriceStandard;
    }

    public void setTotalPriceStandard(int totalPriceStandard) {
        this.totalPriceStandard = totalPriceStandard;
    }
}
