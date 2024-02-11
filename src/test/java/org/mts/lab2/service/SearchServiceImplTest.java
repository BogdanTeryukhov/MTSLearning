package org.mts.lab2.service;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.mts.lab2.inheritors.Cat;
import org.mts.lab2.inheritors.Dog;
import org.mts.lab2.inheritors.Shark;
import org.mts.lab2.inheritors.Wolf;
import org.mts.lab2.interfaces.Animal;
import org.mts.lab2.interfaces.SearchService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SearchServiceImplTest {

    private static final SearchService searchService = new SearchServiceImpl();

    @Test
    @DisplayName("Проверка работоспособности метода findLeapYearName()")
    public void findLeapYearNames() {
        Cat cat = new Cat("kit",LocalDate.of(2016, 10, 20));
        Shark shark = new Shark("kit",LocalDate.of(1904, 10, 20));
        Wolf wolf = new Wolf("kit",LocalDate.of(1905, 10, 20));
        Dog dog = new Dog("kit",LocalDate.of(2015, 10, 20));
        Shark shark2 = new Shark("kit",LocalDate.of(1920, 10, 20));

        Animal[] animals = new Animal[]{cat, shark, wolf, dog, shark2};
        String[] leapYearAnimals_Equals = new String[]{new Cat().getName(), new Shark().getName(), new Shark().getName()};
        String[] leapYearAnimals_NotEquals = new String[]{new Cat().getName(), new Shark().getName()};

        assertArrayEquals(leapYearAnimals_Equals, searchService.findLeapYearNames(animals));
        assertNotEquals(leapYearAnimals_NotEquals, searchService.findLeapYearNames(animals));
    }

    @Test
    @DisplayName("Проверка работоспособности метода findOlderAnimal()")
    public void findOlderAnimal() {
        Cat cat = new Cat("kit",LocalDate.of(2016, 10, 20));
        Shark shark = new Shark("kit",LocalDate.of(1904, 10, 20));
        Wolf wolf = new Wolf("kit",LocalDate.of(1905, 10, 20));
        Dog dog = new Dog("kit",LocalDate.of(2015, 10, 20));
        Shark shark2 = new Shark("kit",LocalDate.of(1920, 10, 20));
        Wolf wolf2 = new Wolf("kit",LocalDate.of(1950, 10, 20));
        Dog dog2 = new Dog("kit",LocalDate.of(2022, 5, 10));

        Animal[] animals = new Animal[]{cat, shark, wolf, dog, shark2, wolf2, dog2};
        Animal[] olderAnimals_Equals = new Animal[]{shark, wolf, shark2, wolf2};
        Animal[] olderAnimals_NotEquals = new Animal[]{cat, shark, wolf, shark2, wolf2, dog2};

        int number = 20;
        assertArrayEquals(olderAnimals_Equals, searchService.findOlderAnimal(animals, number));
        assertNotEquals(olderAnimals_NotEquals, searchService.findOlderAnimal(animals, number));
    }


    @Test
    @DisplayName("Проверка работоспособности метода findDuplicate()")
    public void findDuplicate() {
        Animal[] animals = new Animal[]{
                new Cat("kit",LocalDate.of(2016, 10, 20)), new Wolf(), new Shark(), new Dog(), new Cat("kit",LocalDate.of(2016, 10, 20))};

        List<List<Animal>> duplicatesList_Equals = new ArrayList<>();
        duplicatesList_Equals.add(List.of(animals[0], animals[4]));

        List<List<Animal>> duplicatesList_NotEquals = new ArrayList<>();
        duplicatesList_NotEquals.add(List.of(animals[0], animals[3]));

        assertThat(duplicatesList_Equals, is(searchService.findDuplicate(animals)));
        assertThat(duplicatesList_NotEquals, is(not(searchService.findDuplicate(animals))));
    }
}