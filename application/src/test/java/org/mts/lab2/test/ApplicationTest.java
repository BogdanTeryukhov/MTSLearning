package org.mts.lab2.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mts.enums.AnimalEnum;
import org.mts.inheritors.Cat;
import org.mts.inheritors.Dog;
import org.mts.inheritors.Shark;
import org.mts.inheritors.Wolf;
import org.mts.lab2.service.impl.AnimalsRepositoryImpl;
import org.mts.randomAnimalsCreation.animalFactories.CatFactory;
import org.mts.randomAnimalsCreation.animalFactories.DogFactory;
import org.mts.randomAnimalsCreation.animalFactories.SharkFactory;
import org.mts.randomAnimalsCreation.animalFactories.WolfFactory;
import org.mts.service.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class ApplicationTest {

    @Autowired
    private AnimalsRepositoryImpl animalsRepository;

    @Test
    public void findOlderAnimalsTest(@Mock CatFactory catFactory,
                                     @Mock DogFactory dogFactory,
                                     @Mock WolfFactory wolfFactory,
                                     @Mock SharkFactory sharkFactory) {
        Mockito.doReturn(new Cat("testBarsik", LocalDate.of(2020, 2, 25))).when(catFactory).createRandomAnimal();
        Mockito.doReturn(new Dog("testVzhik", LocalDate.of(2015, 2, 25))).when(dogFactory).createRandomAnimal();
        Mockito.doReturn(new Wolf("testAtos", LocalDate.of(2019, 2, 25))).when(wolfFactory).createRandomAnimal();
        Mockito.doReturn(new Shark("testMuhtar", LocalDate.of(2016, 2, 25))).when(sharkFactory).createRandomAnimal();

        Map<String, List<Animal>> map = new HashMap<>();
        map.put(AnimalEnum.CAT.toString(), List.of(catFactory.createRandomAnimal()));
        map.put(AnimalEnum.DOG.toString(), List.of(dogFactory.createRandomAnimal()));
        map.put(AnimalEnum.WOLF.toString(), List.of(wolfFactory.createRandomAnimal()));
        map.put(AnimalEnum.SHARK.toString(), List.of(sharkFactory.createRandomAnimal()));

        AnimalsRepositoryImpl animalsRepositoryTest = new AnimalsRepositoryImpl();
        animalsRepositoryTest.animals = map;

        Map<Animal, Integer> resultMap = new HashMap<>();
        resultMap.put(new Dog("testVzhik", LocalDate.of(2015, 2, 25)), 9);
        Assertions.assertEquals(animalsRepositoryTest.findOlderAnimal(10), resultMap);
    }

    @Test
    public void testNotNullAnimals() {
        for (Map.Entry<String, List<Animal>> entry : animalsRepository.getAnimals().entrySet()) {
            List<Animal> currentTypeAnimals = entry.getValue();
            for (Animal currentTypeAnimal : currentTypeAnimals) {
                Assertions.assertNotNull(currentTypeAnimal);
            }
        }
    }

    @Test
    public void findAverageAge() {
        List<Animal> animalsList = List.of(new Cat("pete0", LocalDate.of(2015, 9, 20)),
                new Cat("pete1", LocalDate.of(2010, 9, 20)),
                new Cat("pete2", LocalDate.of(2014, 9, 20)));
        System.out.println("\n------------AverageAge-----------\n");
        animalsRepository.findAverageAge(animalsList);
    }

    @Test
    public void findOldAndExpensive() {
        List<Animal> animalsList = List.of(new Cat("pete0", LocalDate.of(2020, 9, 20)),
                new Wolf("pete1", LocalDate.of(2011, 9, 19)),
                new Wolf("pete2", LocalDate.of(2010, 9, 19)));
        //animalsList.forEach(animal -> System.out.println("name: " + animal.getName() + " date: " + animal.getDateOfBirth() + " cost: " + animal.getCost().intValue()));
        System.out.println("\n------------OldAndExpensive-----------\n");
        System.out.println(animalsRepository.findOldAndExpensive(animalsList));
    }

    @Test
    public void findMinCostAnimals() {
        List<Animal> animalsList = List.of(new Cat("dior", LocalDate.of(2020, 9, 20)),
                new Cat("diorb", LocalDate.of(2020, 9, 20)),
                new Cat("diorc", LocalDate.of(2010, 5, 10)),
                new Cat("diord", LocalDate.of(2015, 2, 15)),
                new Wolf("pete4", LocalDate.of(2011, 9, 19)),
                new Wolf("pete5", LocalDate.of(2010, 9, 19)));
        System.out.println("\n------------MinCostAnimals-----------\n");
        //animalsList.forEach(animal -> System.out.println("name: " + animal.getName() + " date: " + animal.getDateOfBirth() + " cost: " + animal.getCost().intValue()));
        System.out.println(animalsRepository.findMinCostAnimals(animalsList));
    }
}
