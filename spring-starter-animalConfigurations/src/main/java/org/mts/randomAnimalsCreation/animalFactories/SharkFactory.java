package org.mts.randomAnimalsCreation.animalFactories;

import org.mts.abstracts.parent.AbstractAnimal;
import org.mts.inheritors.Shark;
import org.mts.randomAnimalsCreation.AnimalProperties;
import org.mts.service.RandomAnimalCreation;
import org.mts.service.RandomChoice;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class SharkFactory implements RandomAnimalCreation, RandomChoice {

    private final AnimalProperties animalProperties;

    public SharkFactory(AnimalProperties animalProperties) {
        this.animalProperties = animalProperties;
    }

    @Override
    public String getRandomAnimalName() {
        List<String> sharksNames = animalProperties.getSharkNames();
        return sharksNames.get(new Random().nextInt(sharksNames.size()));
    }

    @Override
    public AbstractAnimal createRandomAnimal() {
        return new Shark(getRandomAnimalName());
    }

}
