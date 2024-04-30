package org.mts.inheritors;


import org.mts.abstracts.Pet;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Dog extends Pet {

    public Dog() {
    }

    public Dog(String name, LocalDate birth) {
        super(name, birth);
    }

    public Dog(String randomAnimalName) {
        this.name = randomAnimalName;
    }

    public Dog(String randomAnimalName, String secretInfo) {
        this.name = randomAnimalName;
        this.secretInformation = secretInfo;
    }

    public Dog(String breed, String name, BigDecimal cost, String character, LocalDate birth, String secretInformation, int age) {
        super(breed, name, cost, character, birth, secretInformation, age);
    }

    @Override
    public String getBreed() {
        return "Собака";
    }

    @Override
    public String getCharacter() {
        return "Характеристика собаки";
    }


    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                ", secretInformation='" + secretInformation + '\'' +
                ", age=" + age +
                '}';
    }
}
