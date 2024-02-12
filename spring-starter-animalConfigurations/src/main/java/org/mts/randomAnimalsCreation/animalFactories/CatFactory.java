package org.mts.randomAnimalsCreation.animalFactories;

import org.mts.inheritors.Cat;
import org.mts.randomAnimalsCreation.AnimalProperties;
import org.mts.service.Animal;
import org.mts.service.RandomAnimalCreation;
import org.mts.service.RandomChoice;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Random;

@Component
public class CatFactory implements RandomAnimalCreation, RandomChoice {

    private final AnimalProperties animalProperties;

    public CatFactory(AnimalProperties animalProperties) {
        this.animalProperties = animalProperties;
    }

    @Override
    public String getRandomAnimalName() {
        List<String> catsNames = animalProperties.getCatNames();
        //System.out.println(catsNames);
        return catsNames.get(new Random().nextInt(catsNames.size()));
    }

    @Override
    public Animal createRandomAnimal() {
        return new Cat(getRandomAnimalName());
    }
}
