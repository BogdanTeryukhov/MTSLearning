package org.mts.lab2.service;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mts.inheritors.Cat;
import org.mts.inheritors.Dog;
import org.mts.inheritors.Shark;
import org.mts.inheritors.Wolf;
import org.mts.lab2.service.impl.SearchServiceImpl;
import org.mts.randomAnimalsCreation.animalFactories.CatFactory;
import org.mts.randomAnimalsCreation.animalFactories.DogFactory;
import org.mts.randomAnimalsCreation.animalFactories.SharkFactory;
import org.mts.randomAnimalsCreation.animalFactories.WolfFactory;
import org.mts.service.Animal;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class SearchServiceImplTest {

    private static final SearchService searchService = new SearchServiceImpl();

    @Test
    @DisplayName("Проверка работоспособности метода findLeapYearName()")
    public void findLeapYearNames(@Mock CatFactory catFactory,
                                  @Mock DogFactory dogFactory,
                                  @Mock WolfFactory wolfFactory,
                                  @Mock SharkFactory sharkFactory) {

        Mockito.doReturn(new Cat("kit", LocalDate.of(2016, 10, 20))).when(catFactory).createRandomAnimal();
        Mockito.doReturn(new Dog("dogit", LocalDate.of(2015, 2, 25))).when(dogFactory).createRandomAnimal();
        Mockito.doReturn(new Wolf("wolfit", LocalDate.of(1905, 2, 25))).when(wolfFactory).createRandomAnimal();
        Mockito.doReturn(new Shark("sharkit", LocalDate.of(1904, 2, 25))).when(sharkFactory).createRandomAnimal();

        Animal[] animals = new Animal[]{catFactory.createRandomAnimal(), dogFactory.createRandomAnimal(), wolfFactory.createRandomAnimal(), sharkFactory.createRandomAnimal()};
        String[] leapYearAnimals_Equals = new String[]{catFactory.createRandomAnimal().getName(), sharkFactory.createRandomAnimal().getName()};
        String[] leapYearAnimals_NotEquals = new String[]{dogFactory.createRandomAnimal().getName(), wolfFactory.createRandomAnimal().getName()};

        Assertions.assertArrayEquals(leapYearAnimals_Equals, searchService.findLeapYearNames(animals));
        Assertions.assertNotEquals(leapYearAnimals_NotEquals, searchService.findLeapYearNames(animals));
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
        Assertions.assertArrayEquals(olderAnimals_Equals, searchService.findOlderAnimal(animals, number));
        Assertions.assertNotEquals(olderAnimals_NotEquals, searchService.findOlderAnimal(animals, number));
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

        MatcherAssert.assertThat(duplicatesList_Equals, is(searchService.findDuplicate(animals)));
        MatcherAssert.assertThat(duplicatesList_NotEquals, is(not(searchService.findDuplicate(animals))));
    }
}