package org.mts.inheritors;


import org.mts.abstracts.Predator;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Wolf extends Predator {

    public Wolf() {
    }

    public Wolf(String name, LocalDate birth) {
        super(name, birth);
    }

    public Wolf(String randomAnimalName) {
        this.name = randomAnimalName;
    }

    public Wolf(String randomAnimalName, String secretInfo) {
        this.name = randomAnimalName;
        this.secretInformation = secretInfo;
    }

    public Wolf(String breed, String name, BigDecimal cost, String character, LocalDate birth, String secretInformation, int age) {
        super(breed, name, cost, character, birth, secretInformation, age);
    }

    @Override
    public String getBreed() {
        return "Волк";
    }

    @Override
    public String getCharacter() {
        return "Характеристика волка";
    }


}
