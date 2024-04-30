package org.mts.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mts.randomAnimalsCreation.AnimalProperties;
import org.mts.service.CreateAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Map;
import java.util.Random;

//@SpringBootTest
//@ActiveProfiles("test")
//@ExtendWith(MockitoExtension.class)
//class StarterTest {
//
//    @Autowired
//    private CreateAnimalService createAnimalService;
//
//    @Autowired
//    private AnimalProperties animalProperties;
//
//    @Test
//    public void wolfFactoryTest(@Mock WolfFactory wolfFactory) {
//        Mockito.doReturn(new Wolf()).when(wolfFactory).createRandomAnimal();
//        Mockito.doReturn(animalProperties.getWolfNames().get(new Random().nextInt(5))).when(wolfFactory).getRandomAnimalName();
//
//
//        Assertions.assertTrue(wolfFactory.createRandomAnimal() instanceof Wolf
//                && animalProperties.getWolfNames().contains(wolfFactory.getRandomAnimalName()));
//    }
//
//    @Test
//    public void catFactoryTest(@Mock CatFactory catFactory) {
//        Mockito.doReturn(new Cat()).when(catFactory).createRandomAnimal();
//        Mockito.doReturn(animalProperties.getCatNames().get(new Random().nextInt(5))).when(catFactory).getRandomAnimalName();
//
//
//        Assertions.assertTrue(catFactory.createRandomAnimal() instanceof Cat
//                && animalProperties.getCatNames().contains(catFactory.getRandomAnimalName()));
//    }
//
//    @Test
//    public void dogFactoryTest(@Mock DogFactory dogFactory) {
//        Mockito.doReturn(new Dog()).when(dogFactory).createRandomAnimal();
//        Mockito.doReturn(animalProperties.getDogNames().get(new Random().nextInt(5))).when(dogFactory).getRandomAnimalName();
//
//
//        Assertions.assertTrue(dogFactory.createRandomAnimal() instanceof Dog
//                && animalProperties.getDogNames().contains(dogFactory.getRandomAnimalName()));
//    }
//
//    @Test
//    public void sharkFactoryTest(@Mock SharkFactory sharkFactory) {
//        Mockito.doReturn(new Shark()).when(sharkFactory).createRandomAnimal();
//        Mockito.doReturn(animalProperties.getSharkNames().get(new Random().nextInt(5))).when(sharkFactory).getRandomAnimalName();
//
//
//        Assertions.assertTrue(sharkFactory.createRandomAnimal() instanceof Shark
//                && animalProperties.getSharkNames().contains(sharkFactory.getRandomAnimalName()));
//    }
//
//    private List<String> findCurrentAnimalProperties(Animal animal) {
//        switch (animal.getClass().getName().substring(animal.getClass().getName().lastIndexOf('.') + 1)) {
//            case "Cat" -> {
//                return animalProperties.getCatNames();
//            }
//            case "Dog" -> {
//                return animalProperties.getDogNames();
//            }
//            case "Shark" -> {
//                return animalProperties.getSharkNames();
//            }
//            case "Wolf" -> {
//                return animalProperties.getWolfNames();
//            }
//        }
//        throw new RuntimeException("Smt went wrong");
//    }
//
//    @Test
//    public void rightNamesTest() {
//        Map<String, List<AbstractAnimal>> animals = createAnimalService.createAnimals();
//        for (Map.Entry<String, List<AbstractAnimal>> entry : animals.entrySet()) {
//            List<AbstractAnimal> currentTypeAnimals = entry.getValue();
//            for (int i = 0; i < currentTypeAnimals.size(); i++) {
//                List<String> currentAnimalProperty = findCurrentAnimalProperties(currentTypeAnimals.get(i));
//                Assertions.assertTrue(currentAnimalProperty.contains(currentTypeAnimals.get(i).getName()));
//            }
//        }
//    }
//
//    @Test
//    public void rightDatesTest() {
//        Map<String, List<AbstractAnimal>> animals = createAnimalService.createAnimals();
//        for (Map.Entry<String, List<AbstractAnimal>> entry : animals.entrySet()) {
//            List<AbstractAnimal> currentTypeAnimals = entry.getValue();
//            for (int i = 0; i < currentTypeAnimals.size(); i++) {
//                if (currentTypeAnimals.get(i) instanceof Pet) {
//                    Assertions.assertTrue(((Pet) currentTypeAnimals.get(i)).getBirth().getYear() >= 2010 && currentTypeAnimals.get(i).getBirth().getYear() <= 2023);
//                } else {
//                    Assertions.assertTrue(currentTypeAnimals.get(i).getBirth().getYear() >= 1800 && currentTypeAnimals.get(i).getBirth().getYear() <= 2023);
//                }
//            }
//        }
//    }
//}
