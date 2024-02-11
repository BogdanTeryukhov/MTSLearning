package org.mts.abstracts;


import org.mts.abstracts.parent.AbstractAnimal;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends AbstractAnimal {

    public Predator() {
        int year = ThreadLocalRandom.current().nextInt(1800, 2023);
        int month = ThreadLocalRandom.current().nextInt(1, 12);
        int day = (month == 2) ? ThreadLocalRandom.current().nextInt(1, 28) : ThreadLocalRandom.current().nextInt(1, 31);

        birth = LocalDate.of(year, month, day);
    }

    public Predator(String name,LocalDate birth){
        this.name = name;
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
