package org.mts.lab2.inheritors;

import org.mts.lab2.abstracts.Pet;
import org.mts.lab2.abstracts.parent.AbstractAnimal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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

    @Override
    public LocalDate getDateOfBirth() {
        return birth;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "birth=" + birth +
                '}';
    }
}
