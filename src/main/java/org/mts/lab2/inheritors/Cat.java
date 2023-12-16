package org.mts.lab2.inheritors;

import org.mts.lab2.abstracts.Pet;

import java.math.BigDecimal;

public class Cat extends Pet {
    @Override
    public String getBreed() {
        return "Кошка";
    }

    @Override
    public String getName() {
        return "Мягколапка";
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(15000);
    }

    @Override
    public String getCharacter() {
        return "Характеристика кошки";
    }
}
