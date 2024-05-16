package org.mts.lab1.dto;

public class Purchase {
    private String fullPrice;
    private String salePrice;

    public Purchase() {
    }

    public Purchase(String fullPrice, String salePrice) {
        this.fullPrice = fullPrice;
        this.salePrice = salePrice;
    }

    public String getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(String fullPrice) {
        this.fullPrice = fullPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    @Override
    public String toString() {
        return "Без скидки: " + fullPrice + ", Со скидкой: " + salePrice ;
    }
}
