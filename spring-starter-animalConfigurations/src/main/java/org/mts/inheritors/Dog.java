package org.mts.inheritors;


import org.mts.abstracts.Pet;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

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
        return cost;
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
        return "Dog{" + "name=" + name
                + " birth=" + birth +
                '}';
    }
}
