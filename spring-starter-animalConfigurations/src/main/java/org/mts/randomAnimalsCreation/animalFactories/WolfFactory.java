package org.mts.randomAnimalsCreation.animalFactories;

import org.mts.inheritors.Wolf;
import org.mts.randomAnimalsCreation.AnimalProperties;
import org.mts.service.Animal;
import org.mts.service.RandomAnimalCreation;
import org.mts.service.RandomChoice;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Random;

@Component
public class WolfFactory implements RandomAnimalCreation, RandomChoice {

    private final AnimalProperties animalProperties;

    public WolfFactory(AnimalProperties animalProperties) {
        this.animalProperties = animalProperties;
    }

    @Override
    public String getRandomAnimalName() {
        List<String> wolvesNames = animalProperties.getWolfNames();
        //System.out.println(wolvesNames);
        return wolvesNames.get(new Random().nextInt(wolvesNames.size()));
    }

    @Override
    public Animal createRandomAnimal() {
        return new Wolf(getRandomAnimalName());
    }
}
