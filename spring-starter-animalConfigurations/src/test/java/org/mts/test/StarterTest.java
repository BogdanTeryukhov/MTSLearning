package org.mts.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mts.entity.AnimalType;
import org.mts.entity.Creature;
import org.mts.randomAnimalsCreation.AnimalProperties;
import org.mts.randomAnimalsCreation.RandomFactory;
import org.mts.repository.AnimalTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class StarterTest {

    @Autowired
    private AnimalProperties animalProperties;

    @Autowired
    private AnimalTypeRepository animalTypeRepository;

    @Test
    public void wolfFactoryTest(@Mock RandomFactory randomFactory) {
        List<AnimalType> animalTypeList = animalTypeRepository.findAll();
        System.out.println(animalTypeList);
        Mockito.doReturn(new Creature("animal1", 3, animalTypeList.get(2))).when(randomFactory).createRandomAnimal();
        Assertions.assertEquals("wolf", randomFactory.createRandomAnimal().getType().getType());
    }

    @Test
    public void catFactoryTest(@Mock RandomFactory randomFactory) {
        List<AnimalType> animalTypeList = animalTypeRepository.findAll();
        Mockito.doReturn(new Creature("animal1", 1, animalTypeList.get(0))).when(randomFactory).createRandomAnimal();


        Assertions.assertEquals("cat", randomFactory.createRandomAnimal().getType().getType());
    }

    @Test
    public void dogFactoryTest(@Mock RandomFactory randomFactory) {
        List<AnimalType> animalTypeList = animalTypeRepository.findAll();
        Mockito.doReturn(new Creature("animal1", 2, animalTypeList.get(1))).when(randomFactory).createRandomAnimal();


        Assertions.assertEquals("dog", randomFactory.createRandomAnimal().getType().getType());
    }

    @Test
    public void sharkFactoryTest(@Mock RandomFactory randomFactory) {
        List<AnimalType> animalTypeList = animalTypeRepository.findAll();
        Mockito.doReturn(new Creature("animal1", 4, animalTypeList.get(3))).when(randomFactory).createRandomAnimal();


        Assertions.assertEquals("shark", randomFactory.createRandomAnimal().getType().getType());
    }

    private List<String> findCurrentAnimalProperties(Creature creature) {
        switch (creature.getType().getType()) {
            case "cat" -> {
                return animalProperties.getCatNames();
            }
            case "dog" -> {
                return animalProperties.getDogNames();
            }
            case "shark" -> {
                return animalProperties.getSharkNames();
            }
            case "wolf" -> {
                return animalProperties.getWolfNames();
            }
        }
        throw new RuntimeException("Smt went wrong");
    }
}
