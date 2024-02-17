package org.mts.inheritors;


import org.mts.abstracts.Pet;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cat extends Pet {

    public Cat() {
    }

    public Cat(String name, LocalDate birth) {
        super(name, birth);
    }

    public Cat(String randomAnimalName) {
        this.name = randomAnimalName;
    }

    @Override
    public String getBreed() {
        return "Кошка";
    }

    @Override
    public String getName() {
        return name;
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
        return "Cat{" + "name=" + name
                + " birth=" + birth +
                '}';
    }
}
