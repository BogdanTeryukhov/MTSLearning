package org.mts.lab2.service;

import org.mts.lab2.interfaces.Animal;
import org.mts.lab2.interfaces.CreateAnimalService;
import org.mts.lab2.randomAnimalsCreation.RandomFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CreateAnimalServiceImpl implements CreateAnimalService {

    private String animalType;

    @Override
    public Animal[] createParticularNumberOfAnimals(int numberAnimals) {
        Animal[] animals = new Animal[numberAnimals];
        for (int i = 0; i < numberAnimals; i++) {
            animals[i] = RandomFactory.factory.createRandomAnimal();
        }
        return animals;
    }

    @Override
    public Animal[] createAnimals() {
        Animal[] animals = new Animal[10];
        int count = 0;
        do {
            animals[count] = RandomFactory.factory.createRandomAnimal();
            count++;
        } while (count < 10);
        return animals;
    }

    //Поменяешь этот метод на свою логику определения типа
    public String defineTypeOfAnimal() {
        List<String> typesOfAnimals = List.of("type1", "type2");
        Random random = new Random();
        int randomIndex = random.nextInt(typesOfAnimals.size());
        return typesOfAnimals.get(randomIndex);
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }
}
