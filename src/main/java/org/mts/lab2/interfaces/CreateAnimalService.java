package org.mts.lab2.interfaces;

import org.mts.lab2.randomAnimalsCreation.RandomFactory;

public interface CreateAnimalService {

    Animal[] createParticularNumberOfAnimals(int numberAnimals);

    default Animal[] createAnimals(){
        Animal[] animals = new Animal[10];
        int count = 0;
        while (count < 10){
            animals[count] = RandomFactory.factory.createRandomAnimal();
            count++;
        }
        return animals;
    }
}
