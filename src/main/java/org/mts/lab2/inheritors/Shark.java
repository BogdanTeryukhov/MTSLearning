package org.mts.lab2.inheritors;

import org.mts.lab2.abstracts.Predator;

import java.math.BigDecimal;

public class Shark extends Predator {
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
}
