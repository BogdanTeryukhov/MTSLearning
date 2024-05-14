package org.mts.randomAnimalsCreation.animalFactories;

import org.mts.abstracts.parent.AbstractAnimal;
import org.mts.inheritors.Cat;
import org.mts.randomAnimalsCreation.AnimalProperties;
import org.mts.service.RandomAnimalCreation;
import org.mts.service.RandomChoice;
import org.springframework.stereotype.Component;

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
        return catsNames.get(new Random().nextInt(catsNames.size()));
    }

    @Override
    public AbstractAnimal createRandomAnimal() {
        return new Cat(getRandomAnimalName());
    }
}
