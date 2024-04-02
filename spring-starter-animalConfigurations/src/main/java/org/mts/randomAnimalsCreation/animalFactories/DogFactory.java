package org.mts.randomAnimalsCreation.animalFactories;

import org.mts.inheritors.Dog;
import org.mts.randomAnimalsCreation.AnimalProperties;
import org.mts.service.Animal;
import org.mts.service.RandomAnimalCreation;
import org.mts.service.RandomChoice;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Random;

@Component
public class DogFactory implements RandomAnimalCreation, RandomChoice {

    private final AnimalProperties animalProperties;

    public DogFactory(AnimalProperties animalProperties) {
        this.animalProperties = animalProperties;
    }

    @Override
    public String getRandomAnimalName() {
        List<String> dogsNames = animalProperties.getDogNames();
        return dogsNames.get(new Random().nextInt(dogsNames.size()));
    }

    @Override
    public Animal createRandomAnimal() {
        return new Dog(getRandomAnimalName());
    }
}
