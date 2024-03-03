package org.mts.inheritors;


import org.mts.abstracts.Predator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

public class Shark extends Predator {

    public Shark() {
    }

    public Shark(String name,LocalDate birth) {
        super(name,birth);
    }

    public Shark(String randomAnimalName) {
        this.name = randomAnimalName;
    }

    @Override
    public String getBreed() {
        return "Акула";
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
        return "Характеристика акулы";
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
        return "Shark{" + "name=" + name
                + " birth=" + birth +
                '}';
    }
}
