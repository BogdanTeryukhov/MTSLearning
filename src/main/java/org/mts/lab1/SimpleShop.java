package org.mts.lab1;

/**
 * SimpleShop Класс
 */
public class SimpleShop
{
    //количество товаров
    public int numberOfProducts;
    //цена за товар
    public double priceOfProduct;
    //скидка на товар
    public double saleOnProduct;

    public SimpleShop() {
    }

    public SimpleShop(int numberOfProducts, double priceOfProduct, double saleOnProduct) {
        this.numberOfProducts = numberOfProducts;
        this.priceOfProduct = priceOfProduct;
        this.saleOnProduct = saleOnProduct;
    }

    public void calculations(SimpleShop shop){
        System.out.println("Без скидки: " + String.format("%.2f", shop.numberOfProducts * shop.priceOfProduct));

        String result = String.format("%.2f", (shop.priceOfProduct - (shop.priceOfProduct * (shop.saleOnProduct / 100))) * shop.numberOfProducts);
        System.out.println("Со скидкой: " + result + "\n");
    }
}
