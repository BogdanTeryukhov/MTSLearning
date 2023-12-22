package org.mts.lab2.randomAnimalsCreation.animalFactories;

import org.mts.lab2.inheritors.Cat;
import org.mts.lab2.inheritors.Shark;
import org.mts.lab2.interfaces.Animal;
import org.mts.lab2.interfaces.CreateAnimalService;
import org.mts.lab2.interfaces.RandomAnimalCreation;

public class SharkFactory implements RandomAnimalCreation {

    @Override
    public Animal createRandomAnimal() {
        return new Shark();
    }
}
