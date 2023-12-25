package org.mts.lab2.service;

import org.junit.Assert;
import org.junit.Test;
import org.mts.lab2.inheritors.Cat;
import org.mts.lab2.inheritors.Dog;
import org.mts.lab2.inheritors.Shark;
import org.mts.lab2.inheritors.Wolf;
import org.mts.lab2.interfaces.Animal;
import org.mts.lab2.interfaces.SearchService;

import java.time.LocalDate;

public class SearchServiceImplTest {

    private static final SearchService searchService = new SearchServiceImpl();


    @Test
    public void findLeapYearNames() {
        Cat cat = new Cat(LocalDate.of(2016, 10, 20));
        Shark shark = new Shark(LocalDate.of(1904, 10, 20));
        Wolf wolf = new Wolf(LocalDate.of(1905, 10, 20));
        Dog dog = new Dog(LocalDate.of(2015, 10, 20));
        Shark shark2 = new Shark(LocalDate.of(1920, 10, 20));

        Animal[] animals = new Animal[]{cat, shark, wolf, dog, shark2};
        String[] leapYearAnimals = new String[]{new Cat().getName(), new Shark().getName(), new Shark().getName()};
        Assert.assertArrayEquals(leapYearAnimals, searchService.findLeapYearNames(animals));
    }

    @Test
    public void findOlderAnimal() {
        Cat cat = new Cat(LocalDate.of(2016, 10, 20));
        Shark shark = new Shark(LocalDate.of(1904, 10, 20));
        Wolf wolf = new Wolf(LocalDate.of(1905, 10, 20));
        Dog dog = new Dog(LocalDate.of(2015, 10, 20));
        Shark shark2 = new Shark(LocalDate.of(1920, 10, 20));
        Wolf wolf2 = new Wolf(LocalDate.of(1950, 10, 20));
        Dog dog2 = new Dog(LocalDate.of(2022, 5, 10));

        Animal[] animals = new Animal[]{cat, shark, wolf, dog, shark2, wolf2, dog2};
        Animal[] olderAnimals = new Animal[]{shark, wolf, shark2, wolf2};
        int N = 20;

        Assert.assertArrayEquals(olderAnimals, searchService.findOlderAnimal(animals, N));
    }
}