package org.mts.lab1.entity;

/**
 * SimpleShop Класс
 */
public class SimpleShop
{
    //количество товаров
    private int numberProducts;
    //цена за товар
    private double priceProduct;
    //скидка на товар
    private double saleOnProduct;

    public SimpleShop() {
    }

    public SimpleShop(int numberProducts, double priceProduct, double saleOnProduct) {
        this.numberProducts = numberProducts;
        this.priceProduct = priceProduct;
        this.saleOnProduct = saleOnProduct;
    }

    public int getNumberProducts() {
        return numberProducts;
    }

    public void setNumberProducts(int numberOfProducts) {
        this.numberProducts = numberOfProducts;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceOfProduct) {
        this.priceProduct = priceOfProduct;
    }

    public double getSaleOnProduct() {
        return saleOnProduct;
    }

    public void setSaleOnProduct(double saleOnProduct) {
        this.saleOnProduct = saleOnProduct;
    }
}
