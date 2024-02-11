package org.mts.randomAnimalsCreation;


import org.mts.randomAnimalsCreation.animalFactories.CatFactory;
import org.mts.randomAnimalsCreation.animalFactories.DogFactory;
import org.mts.randomAnimalsCreation.animalFactories.SharkFactory;
import org.mts.randomAnimalsCreation.animalFactories.WolfFactory;
import org.mts.service.Animal;
import org.mts.service.RandomAnimalCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class RandomFactory implements RandomAnimalCreation {

    @Autowired
    private CatFactory catFactory;
    @Autowired
    private DogFactory dogFactory;
    @Autowired
    private WolfFactory wolfFactory;
    @Autowired
    private SharkFactory sharkFactory;


    @Override
    public Animal createRandomAnimal() {
        int ind = new Random().nextInt(4);
        if (ind == 0){
            return catFactory.createRandomAnimal();
        }
        else if (ind == 1){
            return dogFactory.createRandomAnimal();
        }
        else if (ind == 2) {
            return wolfFactory.createRandomAnimal();
        }
        else {
            return sharkFactory.createRandomAnimal();
        }
    }
}
