package org.mts.lab2.service;

import org.mts.lab2.interfaces.CreateAnimalService;
import org.mts.lab2.randomAnimalsCreation.RandomFactory;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    public void createParticularNumberOfAnimals(int numberAnimals) {
        System.out.println("\n--Create particular number of Animals--");
        for (int i = 0; i < numberAnimals; i++) {
            System.out.println(RandomFactory.factory.createRandomAnimal().getClass());
        }
    }

    @Override
    public void createAnimals() {
        System.out.println("--Create Animals from service Impl--");
        int count = 0;
        do {
            System.out.println(RandomFactory.factory.createRandomAnimal().getClass());
            count++;
        } while (count < 10);
    }
}
