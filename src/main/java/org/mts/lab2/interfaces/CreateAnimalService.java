package org.mts.lab2.interfaces;

import org.mts.lab2.randomAnimalsCreation.RandomFactory;

public interface CreateAnimalService {
    default void createAnimals(){
        System.out.println("\n--Create animals from interface--");
        int count = 0;
        while (count < 10){
            System.out.println(RandomFactory.factory.createRandomAnimal().getClass());
            count++;
        }
    }
}
