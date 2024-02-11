package org.mts.lab1.service;


import junit.framework.Assert;
import org.junit.Test;
import org.mts.lab1.dto.Purchase;
import org.mts.lab1.dto.SimpleShop;

public class SimpleShopCalculationsServiceTest {

    @Test
    public void calculations() {
        Purchase purchase1 = SimpleShopCalculationsService.calculations(new SimpleShop(15, 1000, 0.75));
        Purchase purchase2 = SimpleShopCalculationsService.calculations(new SimpleShop(15, 1000, 42.575));
        Purchase purchase3 = SimpleShopCalculationsService.calculations(new SimpleShop(15, 1000, 59.1));

        Assert.assertTrue(purchase1.getFullPrice().equals("15000,00") && purchase1.getSalePrice().equals("14887,50"));
        Assert.assertTrue(purchase2.getFullPrice().equals("15000,00") && purchase2.getSalePrice().equals("8613,75"));
        Assert.assertTrue(purchase3.getFullPrice().equals("15000,00") && purchase3.getSalePrice().equals("6135,00"));
    }
}