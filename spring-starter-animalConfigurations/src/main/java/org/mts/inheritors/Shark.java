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
    public String getSecretInformation() {
        return secretInformation;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "Shark{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                ", secretInformation='" + secretInformation + '\'' +
                ", age=" + age +
                '}';
    }
}
