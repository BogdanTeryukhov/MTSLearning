package org.mts.lab1;

import org.mts.lab1.entity.SimpleShop;
import org.mts.lab1.service.SimpleShopCalculationsService;

public class Application {
    public static void main(String[] args) {
        System.out.println(SimpleShopCalculationsService.calculations(new SimpleShop(15, 1000, 0.75)));
        System.out.println(SimpleShopCalculationsService.calculations(new SimpleShop(15, 1000, 42.575)));
        System.out.println(SimpleShopCalculationsService.calculations(new SimpleShop(15, 1000, 59.1)));
    }
}
