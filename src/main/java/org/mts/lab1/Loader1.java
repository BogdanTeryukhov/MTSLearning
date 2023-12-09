package org.mts.lab1;

public class Loader1 {
    public static void main(String[] args) {
        SimpleShop shop = new SimpleShop();
        shop.calculations(new SimpleShop(15, 1000, 0.75));
        shop.calculations(new SimpleShop(15, 1000, 42.575));
        shop.calculations(new SimpleShop(15, 1000, 59.1));
    }
}
