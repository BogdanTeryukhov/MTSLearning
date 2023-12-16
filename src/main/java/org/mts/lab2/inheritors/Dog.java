package org.mts.lab2.inheritors;

import org.mts.lab2.abstracts.Pet;

import java.math.BigDecimal;

public class Dog extends Pet {

    @Override
    public String getBreed() {
        return "Собака";
    }

    @Override
    public String getName() {
        return "Бобик";
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(50000);
    }

    @Override
    public String getCharacter() {
        return "Характеристика собаки";
    }
}
