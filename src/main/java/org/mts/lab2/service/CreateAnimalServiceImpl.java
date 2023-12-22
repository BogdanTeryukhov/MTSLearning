package org.mts.lab2.service;

import org.mts.lab2.interfaces.Animal;
import org.mts.lab2.interfaces.CreateAnimalService;
import org.mts.lab2.randomAnimalsCreation.RandomFactory;

public class CreateAnimalServiceImpl implements CreateAnimalService {

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
}
