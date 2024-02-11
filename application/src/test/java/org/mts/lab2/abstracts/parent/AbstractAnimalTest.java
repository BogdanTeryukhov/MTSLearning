package org.mts.lab2.abstracts.parent;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mts.lab2.inheritors.Cat;
import org.mts.lab2.inheritors.Dog;
import org.mts.lab2.inheritors.Shark;
import org.mts.lab2.inheritors.Wolf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AbstractAnimalTest {

    public static List<Animal> generateNotEqualsAnimals(){
        List<Animal> animalListNotEquals = new ArrayList<>();
        animalListNotEquals.add(new Cat("kit",LocalDate.of(2016, 10, 20)));
        animalListNotEquals.add(new Dog("kit",LocalDate.of(2016, 10, 20)));
        animalListNotEquals.add(new Wolf("kit",LocalDate.of(2016, 10, 20)));
        animalListNotEquals.add(new Shark("kit",LocalDate.of(2016, 10, 20)));

        animalListNotEquals.add(new Cat("kit",LocalDate.of(2020, 10, 21)));
        animalListNotEquals.add(new Dog("kit",LocalDate.of(2020, 10, 21)));
        animalListNotEquals.add(new Wolf("kit",LocalDate.of(2020, 10, 21)));
        animalListNotEquals.add(new Shark("kit",LocalDate.of(2020, 10, 21)));
        return animalListNotEquals;
    }

    public static List<Animal> generateEqualsAnimals(){
        List<Animal> animalListEquals = new ArrayList<>();
        animalListEquals.add(new Cat("kit",LocalDate.of(2016, 10, 20)));
        animalListEquals.add(new Dog("kit",LocalDate.of(2016, 10, 20)));
        animalListEquals.add(new Wolf("kit",LocalDate.of(2016, 10, 20)));
        animalListEquals.add(new Shark("kit",LocalDate.of(2016, 10, 20)));

        animalListEquals.add(new Cat("kit",LocalDate.of(2016, 10, 20)));
        animalListEquals.add(new Dog("kit",LocalDate.of(2016, 10, 20)));
        animalListEquals.add(new Wolf("kit",LocalDate.of(2016, 10, 20)));
        animalListEquals.add(new Shark("kit",LocalDate.of(2016, 10, 20)));
        return animalListEquals;
    }

    @Test
    @DisplayName("Проверка работоспособности переопределённого метода equals")
    public void testEquals() {
        List<Animal> animalListNotEquals = generateNotEqualsAnimals();

        for (int i = 0; i < animalListNotEquals.size() - 1; i++) {
            for (int j = i + 1; j < animalListNotEquals.size(); j++) {
                assertFalse(animalListNotEquals.get(i).equals(animalListNotEquals.get(j)));
            }
        }

        List<Animal> animalListEquals = generateEqualsAnimals();

        for (int i = 0; i < animalListEquals.size() - 1; i++) {
            for (int j = i + 1; j < animalListEquals.size(); j++) {
                if (animalListEquals.get(i).getClass() == animalListEquals.get(j).getClass()){
                    assertTrue(animalListEquals.get(i).equals(animalListEquals.get(j)));
                }
                else {
                    assertFalse(animalListEquals.get(i).equals(animalListEquals.get(j)));
                }
            }
        }
    }
}