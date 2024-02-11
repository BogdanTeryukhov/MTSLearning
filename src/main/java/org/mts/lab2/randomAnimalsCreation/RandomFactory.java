package org.mts.lab2.randomAnimalsCreation;

import org.mts.lab2.service.Animal;
import org.mts.lab2.service.RandomAnimalCreation;
import org.mts.lab2.randomAnimalsCreation.animalFactories.CatFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.mts.lab2.randomAnimalsCreation.animalFactories.DogFactory;
//import org.mts.lab2.randomAnimalsCreation.animalFactories.SharkFactory;
//import org.mts.lab2.randomAnimalsCreation.animalFactories.WolfFactory;


@Component
public class RandomFactory implements RandomAnimalCreation {
    private RandomAnimalCreation[] factories;

    @Autowired
    private CatFactory catFactory;


    public RandomFactory(RandomAnimalCreation[] factories) {
        this.factories = factories;
    }


    @Override
    public Animal createRandomAnimal() {
        //int ind = new Random().nextInt(getFactories().length);
        int ind = 0;
        switch (ind) {
            case 0:
                return catFactory.createRandomAnimal();
        }
        return null;
    }


    public RandomAnimalCreation[] getFactories() {
        return factories;
    }
}
