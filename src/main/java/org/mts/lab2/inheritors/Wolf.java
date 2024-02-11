package org.mts.lab2.inheritors;

import org.mts.lab2.abstracts.Predator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Wolf extends Predator {

    public Wolf() {
    }

    public Wolf(String name,LocalDate birth) {
        super(name,birth);
    }

    public Wolf(String randomAnimalName) {
        this.name = randomAnimalName;
    }

    @Override
    public String getBreed() {
        return "Волк";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(100);
    }

    @Override
    public String getCharacter() {
        return "Характеристика волка";
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
        return "Wolf{" +
                "birth=" + birth +
                '}';
    }
}
