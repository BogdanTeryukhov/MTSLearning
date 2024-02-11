package org.mts.lab2.inheritors;

import org.mts.lab2.abstracts.Pet;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Dog extends Pet {

    public Dog() {
    }

    public Dog(String name, LocalDate birth) {
        super(name,birth);
    }

    public Dog(String randomAnimalName) {
        this.name = randomAnimalName;
    }

    @Override
    public String getBreed() {
        return "Собака";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(50000);
    }

    @Override
    public String getCharacter() {
        return "Характеристика собаки";
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
        return "Dog{" +
                "birth=" + birth +
                '}';
    }
}
