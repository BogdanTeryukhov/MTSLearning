package org.mts.inheritors;


import org.mts.abstracts.Pet;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

public class Cat extends Pet {


    public Cat() {
    }

    public Cat(String name, LocalDate birth) {
        super(name, birth);
    }

    public Cat(String randomAnimalName) {
        this.name = randomAnimalName;
    }
    public Cat(String randomAnimalName, String secretInfo) {
        this.name = randomAnimalName;
        this.secretInformation = secretInfo;
    }

    public Cat(String breed, String name, BigDecimal cost, String character, LocalDate birth, String secretInformation, int age) {
        super(breed, name, cost, character, birth, secretInformation, age);
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
        return cost;
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
    public String getSecretInformation() {
        return secretInformation;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }


    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                ", secretInformation='" + secretInformation + '\'' +
                ", age=" + age +
                '}';
    }
}
