package org.mts.lab2.randomAnimalsCreation;

import org.mts.lab2.randomAnimalsCreation.animalFactories.CatFactory;
import org.mts.lab2.randomAnimalsCreation.animalFactories.DogFactory;
import org.mts.lab2.randomAnimalsCreation.animalFactories.SharkFactory;
import org.mts.lab2.randomAnimalsCreation.animalFactories.WolfFactory;
import org.mts.lab2.interfaces.Animal;
import org.mts.lab2.interfaces.RandomAnimalCreation;

import java.util.Random;

public class RandomFactory implements RandomAnimalCreation {
    private RandomAnimalCreation[] factories;

    public static final RandomFactory factory = new RandomFactory(new RandomAnimalCreation[]{
            new CatFactory(),
            new DogFactory(),
            new SharkFactory(),
            new WolfFactory()
    });

    public RandomFactory(RandomAnimalCreation[] factories) {
        this.factories = factories;
    }


    @Override
    public Animal createRandomAnimal() {
        int ind = new Random().nextInt(getFactories().length);
        return getFactories()[ind].createRandomAnimal();
    }

    public RandomAnimalCreation[] getFactories() {
        return factories;
    }
}
