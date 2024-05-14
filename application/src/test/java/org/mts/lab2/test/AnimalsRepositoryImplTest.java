package org.mts.lab2.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mts.entity.AnimalType;
import org.mts.entity.Creature;
import org.mts.lab2.exception.checked.InputListIsEmptyException;
import org.mts.lab2.service.impl.AnimalsRepositoryImpl;
import org.mts.randomAnimalsCreation.RandomFactory;
import org.mts.repository.AnimalTypeRepository;
import org.mts.repository.CreatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class AnimalsRepositoryImplTest {

    @Autowired
    private AnimalsRepositoryImpl animalsRepository;
    @Autowired
    private AnimalTypeRepository animalTypeDao;
    @Autowired
    private CreatureRepository creatureDao;

    @Test
    public void findOlderAnimalsTest(@Mock RandomFactory randomFactory) {
        List<AnimalType> animalTypes = animalTypeDao.findAll();
        Mockito.doReturn(new Creature("testBarsik", 1, (short) 1001, animalTypes.get(0))).when(randomFactory).createRandomAnimal();
        Creature factoryRandomAnimal = randomFactory.createRandomAnimal();
        creatureDao.save(factoryRandomAnimal);

        CopyOnWriteArrayList<Creature> resultList = new CopyOnWriteArrayList<>();
        resultList.add(factoryRandomAnimal);

        System.out.println("Anim");
        animalsRepository.findOlderAnimal(1000).forEach((creature) -> System.out.println("Name: " + creature.getName() + " Age: " + creature.getAge()));
        System.out.println("Result");
        resultList.forEach((creature) -> System.out.println("Name: " + creature.getName() + " Age: " + creature.getAge()));
        Assertions.assertEquals(animalsRepository.findOlderAnimal(1000), resultList);
    }

    @Test
    public void findAverageAge() {
        List<AnimalType> animalTypes = animalTypeDao.findAll();
        List<Creature> animalsList = List.of(new Creature("name1", 1, animalTypes.get(0)),
            new Creature("name1", 1, animalTypes.get(0)),
                    new Creature("name1", 1, animalTypes.get(0)));
        CopyOnWriteArrayList<Creature> concurrentAnimalsList = new CopyOnWriteArrayList<>(animalsList);
        System.out.println("\n------------AverageAge-----------\n");
        try {
            animalsRepository.findAverageAge(concurrentAnimalsList);
        } catch (InputListIsEmptyException exception) {
            System.out.println("Input list is empty!");
        }

    }
}
