package org.mts.randomAnimalsCreation.animalFactories;

import lombok.RequiredArgsConstructor;

import org.mts.inheritors.Shark;
import org.mts.randomAnimalsCreation.AnimalProperties;
import org.mts.service.Animal;
import org.mts.service.RandomAnimalCreation;
import org.mts.service.RandomChoice;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Random;

@Component
@Validated
@RequiredArgsConstructor
public class SharkFactory implements RandomAnimalCreation, RandomChoice {

    private final AnimalProperties animalProperties;

    @Override
    public String getRandomAnimalName() {
        List<String> sharksNames = animalProperties.getSharkNames();
        //System.out.println(sharksNames);
        return sharksNames.get(new Random().nextInt(sharksNames.size()));
    }

    @Override
    public Animal createRandomAnimal() {
        return new Shark(getRandomAnimalName());
    }

}
