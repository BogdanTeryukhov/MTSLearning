package org.mts.inheritors;


import org.mts.abstracts.Predator;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Shark extends Predator {

    public Shark() {
    }

    public Shark(String name, LocalDate birth) {
        super(name, birth);
    }

    public Shark(String randomAnimalName) {
        this.name = randomAnimalName;
    }

    public Shark(String randomAnimalName, String secretInfo) {
        this.name = randomAnimalName;
        this.secretInformation = secretInfo;
    }

    public Shark(String breed, String name, BigDecimal cost, String character, LocalDate birth, String secretInformation, int age) {
        super(breed, name, cost, character, birth, secretInformation, age);
    }

    @Override
    public String getBreed() {
        return "Акула";
    }

    @Override
    public String getCharacter() {
        return "Характеристика акулы";
    }


}
