package org.mts.lab1.service;

import org.mts.lab1.dto.Purchase;
import org.mts.lab1.dto.SimpleShop;

public class SimpleShopCalculationsService {

    public static Purchase calculations(SimpleShop shop){
        Purchase purchase = new Purchase();
        if (shop.getPriceProduct() > 0 && shop.getNumberProducts() > 0){
            purchase.setFullPrice(String.format("%.2f",shop.getNumberProducts() * shop.getPriceProduct()));
            purchase.setSalePrice(String.format("%.2f", (shop.getPriceProduct() - (shop.getPriceProduct() * (shop.getSaleOnProduct() / 100))) * shop.getNumberProducts()));
            return purchase;
        }
        throw new RuntimeException("Количество товаров и цена должны быть > 0");
    }
}
