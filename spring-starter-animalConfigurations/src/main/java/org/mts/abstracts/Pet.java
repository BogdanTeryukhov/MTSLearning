package org.mts.abstracts;


import org.mts.abstracts.parent.AbstractAnimal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Pet extends AbstractAnimal {
    public Pet() {
        int year = ThreadLocalRandom.current().nextInt(2010, 2023);
        int month = ThreadLocalRandom.current().nextInt(1, 12);
        int day = (month == 2) ? ThreadLocalRandom.current().nextInt(1, 28) : ThreadLocalRandom.current().nextInt(1, 31);

        birth = LocalDate.of(year, month, day);
    }
    public Pet(String name, LocalDate birth){
        this.name = name;
        this.birth = birth;
        cost = new BigDecimal(new Random().nextInt(1000,2000));
    }

    public Pet(String breed, String name, BigDecimal cost, String character, LocalDate birth, String secretInformation, int age) {
        super(breed, name, cost, character, birth, secretInformation, age);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
