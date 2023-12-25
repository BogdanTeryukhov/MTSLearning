package org.mts.lab2.inheritors;

import org.mts.lab2.abstracts.Predator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Shark extends Predator {

    public Shark() {
    }

    public Shark(LocalDate birth) {
        super(birth);
    }

    @Override
    public String getBreed() {
        return "Акула";
    }

    @Override
    public String getName() {
        return "Акула из подводной братвы";
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(5550000);
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
        return "Shark{" +
                "birth=" + birth +
                '}';
    }
}
